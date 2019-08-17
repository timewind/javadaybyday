package com.nivelle.guide.dubboprovider.service;

import com.nivelle.guide.dubboapi.HelloDubboService;
import com.alibaba.dubbo.config.annotation.Service;

/**
 * dubbo服务提供者
 *
 * @author fuxinzhong
 * @date 2019/08/17
 */


@Service(version = "${helloDubbo.service.version}")
public class HelloDubboServiceImpl implements HelloDubboService {


    @Override
    public String sayHello(String name) {
        return "Hello, " + name + " (from Spring Boot)";
    }
}
