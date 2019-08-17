package com.nivelle.guide.dubboprovider.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO:DOCUMENT ME!
 *
 * @author fuxinzhong
 * @date 2019/08/17
 */
@RestController
@RequestMapping("/test")
public class TestDubboProvider {

    @RequestMapping("/ok")
    @ResponseBody
    public String test(){
        System.out.println("dubbo provider is ok");

        return "ok";
    }
}
