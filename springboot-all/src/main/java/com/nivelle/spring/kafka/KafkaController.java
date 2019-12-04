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

    /**
     * 自定义分区
     * @return
     */
    @RequestMapping("/send")
    @ResponseBody
    public String sendKafka() {
        kafkaSendService.send();
        return "success";
    }

    /**
     * 默认分区
     * @return
     */
    @RequestMapping("/send2")
    @ResponseBody
    public String sendKafka2() {
        kafkaSendService.send2();
        return "success";
    }

    /**
     * 过滤器
     * @return
     */
    @RequestMapping("/send3")
    @ResponseBody
    public String sendKafka3() {
        kafkaSendService.send3();
        return "success";
    }
}