package com.nivelle.guide.javabase.javacore.proxy;

public class CGlibProxy {

    public static void main(String[] args)
    {
        CGlibHosee cGlibHosee = new CGlibHosee();
        CGlibHoseeProxy cGlibHoseeProxy = new CGlibHoseeProxy();
        CGlibHosee proxy = (CGlibHosee) cGlibHoseeProxy.bind(cGlibHosee);
        System.out.println(proxy.sayhi());
    }
}