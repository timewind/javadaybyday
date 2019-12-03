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
            System.err.println("record---->" + record + "record ------>" + message);
        }

    }

    @KafkaListener(topics = "defautTopic")
    public void listen2(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.err.println("record---->" + record + "record ------>" + message);
        }

    }
}
