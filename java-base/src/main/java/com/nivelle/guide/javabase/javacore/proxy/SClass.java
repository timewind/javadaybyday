package com.nivelle.guide.javabase.javacore.proxy;

public class SClass extends SSClass {

    static {
        System.out.println("SClass init!");
    }

    public static int value = 123;

    public SClass() {
        System.out.println("init SClass");
    }

}
