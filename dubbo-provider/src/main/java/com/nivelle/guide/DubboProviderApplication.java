package com.nivelle.guide;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.nivelle.guide.model.Dog;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Arrays;


@SpringBootApplication
@EnableDubbo
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@EnableAsync
//@ComponentScan(value = "com.nivelle.guide", excludeFilters ={@ComponentScan.Filter(type = FilterType.CUSTOM, classes = {MyTypeFilter.class})})
public class DubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            System.out.println("springBoot 初始化时所有bean定义:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
            System.out.println("springBoot 初始化时所有bean实例定义:");
            String[] objectNames = ctx.getBeanNamesForType(Dog.class);
            for (String objectName : objectNames) {
                System.err.println(objectName);
            }
        };
    }

}
