package com.nivelle.spring.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * TODO:DOCUMENT ME!
 *
 * @author fuxinzhong
 * @date 2019/07/25
 */
@Controller
@RequestMapping(value = "test/kafka")
public class KafkaController {

    @Autowired
    KafkaSendService kafkaSendService;

    @RequestMapping("/send")
    @ResponseBody
    public String sendKafka() {
        kafkaSendService.send();
        return "success";
    }
}
