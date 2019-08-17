package com.nivelle.guide.dubbo.consumer;


import com.alibaba.dubbo.config.annotation.Reference;
import com.nivelle.guide.dubboapi.HelloDubboService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * dubbo demo
 *
 * @author fuxinzhong
 * @date 2019/08/16
 */
@RestController
@RequestMapping("/dubbo")
public class HelloConsumerController {

    @Reference(version = "${helloDubbo.service.version}")
    private HelloDubboService helloDubboService;


    @RequestMapping("/sayHello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return helloDubboService.sayHello(name);
    }


}
