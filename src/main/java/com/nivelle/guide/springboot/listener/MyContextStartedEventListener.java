package com.nivelle.guide.springboot.listener;

import com.nivelle.guide.springboot.pojo.TimeLine;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

import java.util.Date;

/**
 * 上下文已经准备完毕的时候触发
 * <p>
 * 用于容器初始化完成之后，执行需要处理的一些操作，比如一些数据的加载、初始化缓存、特定任务的注册等等
 *
 * **支持启动配置和@Component配置**
 */

public class MyContextStartedEventListener implements ApplicationListener<ContextStartedEvent> {

    /**
     * 需要注意的是，在普通Spring环境中，基于ApplicationListener的监听器的onApplicationEvent方法可能会被执行多次
     */
    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.err.println("ContextStartedEvent 监听到容器初始化成功,可以注册bean");
    }
}
