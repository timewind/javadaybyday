package com.nivelle.spring.kafka;

/**
 * consumer消费者
 *
 * @author fuxinzhong
 * @date 2019/07/25
 */

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@EnableKafka
public class Consumer {

    @KafkaListener(topics = "KafkaLearn")
    public void listen(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.err.println("top is:" + record.topic() + ";record:" + record);
        }

    }

    @KafkaListener(id = "defaultId", topics = "defautTopic",containerFactory = "concurrentListenContainerFactory")
    public void listen2(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.err.println("top is:" + record.topic() + ";record:" + record);
        }
    }

    @KafkaListener(id = "filterTopicId", topics = "filterTopic", containerFactory = "concurrentListenContainerFactory",
            errorHandler = "consumerAwareErrorHandler")
    public void listen3(String data) {
        /**
         * 被过滤掉的空消息不能转为ConsumerRecord
         */
        System.out.println("record is:" + data);
    }
}
