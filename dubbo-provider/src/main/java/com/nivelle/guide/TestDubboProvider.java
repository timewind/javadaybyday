package com.nivelle.guide;

import com.nivelle.guide.model.UserInfo;
import com.nivelle.guide.service.AsyncService;
import com.nivelle.guide.service.impl.XmlBeanServiceImpl;
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


    @RequestMapping("/ok")
    @ResponseBody
    public Object test() {
        System.out.println("dubbo provider is ok");
        UserInfo userInfo = new UserInfo();
        return userInfo;
    }

    /**
     * 通过xml配置文件导入不能自动扫描到的实例
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
     * @return
     * @throws Exception
     */
    @RequestMapping("async")
    @ResponseBody
    public Object testAsyncService() throws Exception{
        String result = "default";
        Future<String> asyncResult = asyncService.asyncSayHello();
        if(asyncResult.isDone()){
            return asyncResult.get();
        }
        return result;
    }

    /**
     * 异步方法调用
     * @return
     * @throws Exception
     */
    @RequestMapping("sync")
    @ResponseBody
    public Object testSyncService() throws Exception{
        String result = "default";
        Future<String> asyncResult = asyncService.asyncSayHello2();
        if(asyncResult.isDone()){
            return asyncResult.get();
        }
        return result;
    }
}
