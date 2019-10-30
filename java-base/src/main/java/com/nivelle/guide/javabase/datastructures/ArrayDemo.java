package com.nivelle.guide.javabase.datastructures;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Arrays 和 Collections
 *
 * @author fuxinzhong
 * @date 2019/10/29
 */
public class ArrayDemo {

    public static void main(String[] args) {


        /**
         * 严格意义上说返回的是数组的一个视图
         *
         * （1）该方法不适用于基本数据类型（byte,short,int,long,float,double,boolean）
         *
         * （2）该方法将数组与列表链接起来，当更新其中之一时，另一个自动更新
         *
         * （3）不支持add和remove方法
         */
        int[] intArray = {1, 2, 3, 4};
        List list = Arrays.asList(intArray);
        System.out.println(list);

        /**
         * 只有元素是对象类型的才能够转换为List,因为用到了范型
         */
        Integer[] integerArray = {1, 2, 3, 4};
        List<Integer> list2 = Arrays.asList(integerArray);
        System.out.println(list2);

        /**
         * string对象
         */
        String[] stringArray = {"1", "2", "3", "4"};
        List<String> list3 = Arrays.asList(stringArray);
        System.out.println(list3);

        /**
         *  Arrays.asList 返回的list是一个内部类,没有remove,add等方法
         *
         *  异常:java.lang.UnsupportedOperationException
         */
        //list3.remove("1");
        //list3.add("5");
        System.out.println("删除元素:" + list3);
        Iterator iterator = list3.iterator();
        while (iterator.hasNext()) {
            System.out.print("iterator: " + iterator.next() + ";");
        }

        System.out.println();

        /**
         * Arrays.asList 返回的list底层是源数组,只不过是一个引用
         */
        list3.set(3, "5");

        for (int i = 0; i < stringArray.length; i++) {
            System.out.print("stringArray" + i + ":" + stringArray[i]+" ");
        }
        System.out.println();
        System.out.println("list3:" + list3);


    }

}
