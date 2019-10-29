package com.nivelle.guide.javabase.designpatterns.proxy;

import com.nivelle.guide.javabase.pojo.User;

public interface CompanyUser {

    boolean doEasyWork(User user);

    boolean doHardWork(User user);
}
