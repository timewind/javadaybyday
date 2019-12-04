package com.nivelle.spring.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.converter.MessagingMessageConverter;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

import java.util.HashMap;
import java.util.Map;


/**
 * 消费者配置
 *
 * @author fuxinzhong
 * @date 2019/12/04
 */
@Configuration
@PropertySource("classpath:config/application.properties")
public class KafkaConsumerConfig {

    @Value("${spring.kafka.consumer.servers}")
    private String servers;
    @Value("${spring.kafka.consumer.enable-auto-commit}")
    private boolean enableAutoCommit;
    @Value("${spring.kafka.consumer.key-deserializer}")
    private String keyDeserializer;
    @Value("${spring.kafka.consumer.value-deserializer}")
    private String valueDeserializer;
    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;
    @Value("${spring.kafka.consumer.session.timeout}")
    private int sessionTimeOut;
    @Value("${spring.kafka.consumer.auto.commit.interval}")
    private int autoCommitInterval;
    @Value("${spring.kafka.consumer.auto.offset.reset}")
    private String autoOffSetReset;
    @Value("${spring.kafka.consumer.concurrency}")
    private int concurrency;


    public Map<String, Object> ConsumerConfigs() {
        Map<String, Object> props = new HashMap<>(12);
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommit);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeserializer);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueDeserializer);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeOut);
        props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, autoCommitInterval);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffSetReset);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, concurrency);
        return props;
    }


    @Bean(value = "listenContainerFactory")
    public ConsumerFactory listenContainerFactory() {
        ConsumerFactory factory = new DefaultKafkaConsumerFactory<>(ConsumerConfigs());
        return factory;
    }

    @Bean(value = "concurrentListenContainerFactory")
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Integer, String>> concurrentListenContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new
                ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(listenContainerFactory());
        //设置可以丢弃消息  配合RecordFilterStrategy使用
        factory.setAckDiscarded(true);
        //设置为批量监听
        factory.setBatchListener(true);
        factory.setRecordFilterStrategy(new MyKafkaRecordFilterStrategy());
        return factory;
    }
}
