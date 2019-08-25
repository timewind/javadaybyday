package com.nivelle.guide;

import com.nivelle.guide.service.AsyncService;
import com.nivelle.guide.service.ConcreteService;
import com.nivelle.guide.service.impl.XmlBeanServiceImpl;
import com.nivelle.guide.spring.initdemo.InitSpringBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.concurrent.Future;

/**
 * @author fuxinzhong
 * @date 2019/08/17
 */
@RestController
@RequestMapping("/test")
public class TestDubboProvider {
    /**
     * 获取上下文
     */
    @Autowired
    WebApplicationContext webApplicationConnect;

    @Autowired
    AsyncService asyncService;

    @Autowired
    InitSpringBean initSpringBean;

    /**
     * 必须添加了@Component 或则 @Service才能添加到spring容器中,但是通过 ImportBeanDefinitionRegistrar实现动态注入bean
     */
    @Autowired
    ConcreteService concreteService;

    @RequestMapping("/ok")
    @ResponseBody
    public Object test() {
        System.out.println("dubbo provider is ok");
        /**
         * springboot默认属性未设置值时为null,可设置为""
         */
        //UserInfo userInfo = new UserInfo();
        Object object = webApplicationConnect.getBean("userInfo");
        return object;
    }

    /**
     * 通过xml配置文件导入不能自动扫描到的实例
     *
     * @return
     */
    @RequestMapping("xml")
    @ResponseBody
    public Object testXmlService() {
        Object xmlBeanService = webApplicationConnect.getBean("xmlService");
        XmlBeanServiceImpl xmlBeanService1 = (XmlBeanServiceImpl) xmlBeanService;
        return xmlBeanService1.helloXmlService();
    }

    /**
     * 异步方法调用
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("async")
    @ResponseBody
    public Object testAsyncService() throws Exception {
        String result = "default";
        Future<String> asyncResult = asyncService.asyncSayHello();
        if (asyncResult.isDone()) {
            return asyncResult.get();
        }
        return result;
    }

    /**
     * 异步方法调用
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("sync")
    @ResponseBody
    public Object testSyncService() throws Exception {
        String result = "default";
        Future<String> asyncResult = asyncService.asyncSayHello2();
        if (asyncResult.isDone()) {
            return asyncResult.get();
        }
        return result;
    }

    /**
     * spring 钩子方法测试
     *
     * @return
     */
    @RequestMapping("/init")
    @ResponseBody
    public Object myInitSpringBean() {
        String name = initSpringBean.getName();
        int age = initSpringBean.getAge();
        concreteService.sayHello();
        return name + age;
    }
}
