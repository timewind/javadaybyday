package com.nivelle.dubbo.service;

import org.springframework.stereotype.Service;

/**
 * @author fuxinzhong
 * @date 2019/08/25
 */
@Service
public class ConcreteService {

    public void sayHello() {
        System.err.println("ConcreteService say hello!");
    }
}
