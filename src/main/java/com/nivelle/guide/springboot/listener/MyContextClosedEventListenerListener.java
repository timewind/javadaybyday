package com.nivelle.guide.springboot.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.stereotype.Component;


@Component
public class MyContextClosedEventListenerListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.err.println("ContextClosedEvent 监听到容器close");
    }
}
