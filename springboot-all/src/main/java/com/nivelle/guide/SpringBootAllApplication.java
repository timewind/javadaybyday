package com.nivelle.guide;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.nivelle.guide.springboot.listener.context.MyContextClosedEventListenerListener;
import com.nivelle.guide.springboot.listener.context.MyContextRefreshedEventListener;
import com.nivelle.guide.springboot.listener.context.MyContextStartedEventListener;
import com.nivelle.guide.springboot.listener.context.MyContextStopedEventEventListener;
import com.nivelle.guide.springboot.listener.springApplicationRunListeners.*;
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
        SpringApplication springApplication = new SpringApplication(SpringBootAllApplication.class);

        /**
         * ApplicationListener 接口监听类
         */
        springApplication.addListeners(new MyApplicationStartingEventListener());
        springApplication.addListeners(new MyApplicationEnvironmentPreparedEventListener());
        springApplication.addListeners(new MyApplicationReadyEventListener());
        //与MyApplicationStartedEventListener互斥
        springApplication.addListeners(new MyApplicationFailedEventListener());
        springApplication.addListeners(new MyApplicationStartedEventListener());

        /**
         * Spring内置的事件
         */
        springApplication.addListeners(new MyContextStartedEventListener());
        springApplication.addListeners(new MyContextRefreshedEventListener());
        springApplication.addListeners(new MyContextClosedEventListenerListener());
        springApplication.addListeners(new MyContextStopedEventEventListener());


        springApplication.run(args);
        System.err.println("启动成功！！");
    }
}
