package com.nivelle.guide.javabase.javacore.proxy;

public class SubClass extends SClass {

    static{
        System.out.println("SubClass init");
    }

    static int a;

    public SubClass(){
        System.out.println("init SubClass");
    }
}
