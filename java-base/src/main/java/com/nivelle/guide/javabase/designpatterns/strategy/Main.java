package com.nivelle.guide.javabase.designpatterns.strategy;

/**
 * 策略模式
 */
public class Main {

    public static void main(String[] args) {
        WorkStrategy workStrategyLeft = new LeftRead();

        WorkStrategy workStrategyRight = new RightRead();

        workStrategyLeft.readName("nivelle");
        System.out.println();
        workStrategyRight.readName("nivelle");
    }
}
