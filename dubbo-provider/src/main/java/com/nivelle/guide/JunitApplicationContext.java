package com.nivelle.guide;

import com.nivelle.guide.config.MyProfileConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 自定义测试
 *
 * @author fuxinzhong
 * @date 2019/09/25
 */
public class JunitApplicationContext {

    /**
     * spring源码学习
     *
     * @param args
     */
    public static void main(String args[]) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        ConfigurableEnvironment configurableEnvironment = annotationConfigApplicationContext.getEnvironment();
        configurableEnvironment.setActiveProfiles("dev");
        System.err.println("====================");
        annotationConfigApplicationContext.register(MyProfileConfig.class);
        //必须要刷新一下
        annotationConfigApplicationContext.refresh();
        String[] beans = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (int i = 0; i < beans.length; i++) {
            System.err.println("当前扫描到的bean定义2:" + beans[i]);
        }

    }


}
