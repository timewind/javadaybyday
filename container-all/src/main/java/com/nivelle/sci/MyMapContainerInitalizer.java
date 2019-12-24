package com.nivelle.sci;

import javax.servlet.ServletContext;

/**
 * TODO:DOCUMENT ME!
 *
 * @author fuxinzhong
 * @date 2019/12/25
 */
public class MyMapContainerInitalizer implements MyContainerInitalizer {
    @Override
    public void onStartup(ServletContext context) {
        context.setAttribute("MyMapContainerInitalizer", this);
        System.out.println("MyMapContainerInitalizer Init ...");
    }
}

