package com.nivelle.guide;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.nivelle.guide.springboot.listener.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ServletComponentScan//扫描servlet组件注解
@EnableCaching//开启缓存注解,mybatis使用redis作为缓存
@EnableScheduling//开启定时任务注解
@EnableRabbit//开启rabbitMQ注解支持
@EnableSwagger2 //swagger2支持
@EnableDubbo//开启dubbo
public class SpringBootAllApplication {
    public static void main(String[] args) {
        SpringApplication springApplication= new SpringApplication(SpringBootAllApplication.class);
        springApplication.addListeners(new MyApplicationStartingEventListener());
        springApplication.addListeners(new MyApplicationEnvironmentPreparedEventListener());
        springApplication.addListeners(new MyApplicationReadyEventListener());
        springApplication.addListeners(new MyContextStartedEventListener());
        springApplication.addListeners(new MyApplicationFailedEventListener());
        springApplication.addListeners(new MyApplicationStartedEventListener());
        springApplication.addListeners(new MyContextRefreshedEventListener());
        springApplication.run(args);
        System.err.println("启动成功！！");
    }
}

