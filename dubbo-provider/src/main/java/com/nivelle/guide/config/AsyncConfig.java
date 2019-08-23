package com.nivelle.guide.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * 开启异步执行功能,配置两个线程池
 *
 * @author fuxinzhong
 * @date 2019/08/23
 */
@Configuration
@EnableAsync
public class AsyncConfig {


    @Bean(name = "littleExecutor")
    public Executor littleExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(10);
        executor.setThreadNamePrefix("littleExecutor-");
        executor.initialize();
        return executor;
    }

    @Bean(name = "largeExecutor")
    public Executor largeExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);
        executor.setMaxPoolSize(100);
        executor.setQueueCapacity(20);
        executor.setThreadNamePrefix("largeExecutor-");
        executor.initialize();
        return executor;
    }

}
