package com.nivelle.guide.springboot.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;


@Component
public class MyContextStopedEventEventListener implements ApplicationListener<ContextStoppedEvent> {

    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {

        System.err.println("ContextStoppedEvent 监听到容器初始化成功,可以注册bean");
    }
}
