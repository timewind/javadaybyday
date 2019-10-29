package com.nivelle.guide.javabase.designpatterns.adapter;

public class PrintBanner extends Banner implements Print {


    public String printFix(String title) {

        String result = super.showWithTail(title);
        System.out.println(result);

        return result;

    }
}
