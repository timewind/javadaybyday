package com.nivelle.guide.datastructures;

import com.nivelle.guide.springboot.pojo.User;
import sun.reflect.Reflection;

import java.lang.reflect.Constructor;

/**
 * Reflection
 *
 * @author fuxinzhong
 * @date 2019/07/19
 */
public class ReflectDemo {

    public static void main(String[] args) throws Exception{

        Reflection reflection = new Reflection();


        Class driver = Class.forName("com.mysql.cj.jdbc.Driver") ;

        Class user = Class.forName("com.nivelle.guide.springboot.pojo.User") ;

        System.out.println(driver);


        Constructor constructor =  user.getConstructor(int.class,String.class);
        User userInstance = (User) constructor.newInstance(12,"ReflectTest");

        System.out.println(userInstance.getName());



    }
}
