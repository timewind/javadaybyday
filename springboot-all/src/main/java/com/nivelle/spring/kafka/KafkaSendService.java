package com.nivelle.spring.kafka;

import com.nivelle.spring.springboot.entity.KafkaMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * kafka 消息发送
 *
 * @author fuxinzhong
 * @date 2019/07/25
 */
@Service
public class KafkaSendService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send() {
        try {
            KafkaMessage message = new KafkaMessage();
            message.setId("NIVELLE_" + System.currentTimeMillis());
            message.setMsg("nivelle1");
            message.setSendTime(new Date());
            kafkaTemplate.send("KafkaLearn", "nivelle", message.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void send2() {
        try {
            KafkaMessage message = new KafkaMessage();
            message.setId("NIVELLE_" + System.currentTimeMillis());
            message.setMsg("jessy1");
            message.setSendTime(new Date());
            kafkaTemplate.send("defautTopic", message.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void send3() {
        try {
            KafkaMessage message = new KafkaMessage();
            message.setId("NIVELLE_" + System.currentTimeMillis());
            message.setMsg("jessy2");
            message.setSendTime(new Date());
            kafkaTemplate.send("filterTopic", "jessy", message.toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
