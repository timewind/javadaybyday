package com.nivelle.base.datastructures;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 所有java类的父类
 *
 * @author fuxinzhong
 * @date 2019/12/12
 */
public class ObjectDemo {


    public static void main(String[] args) {
        Object object = new Object();
        System.out.println("类名+hashCode的无符号16进制:" + object.toString());
        // 存储0-9的列表
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println("原列表：");
        System.out.println(list);
        List tempList = Lists.newArrayList();

        // 筛选列表中的偶数
        list = list.stream().filter(a -> filter(a, tempList)).collect(Collectors.toList());
        System.out.println("列表中的偶数：");
        System.out.println(list);
        System.out.println("临时表数据:" + tempList);
    }

    public static boolean filter(int a, List list) {
        list.add(a);
        return false;
    }
}
