package com.nivelle.guide.javabase.javacore.annotion.myannotion;

public class EnglishUserImpl implements IUser {
    @Override
    public void login() {
        System.err.println("User Login！");
    }
}

