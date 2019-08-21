package com.nivelle.guide;

import com.nivelle.guide.model.UserInfo;
import com.nivelle.guide.service.XmlBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

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
        XmlBeanService xmlBeanService1 = (XmlBeanService) xmlBeanService;
        return xmlBeanService1.helloXmlService();
    }
}
