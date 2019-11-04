package com.nivelle.guide.javabase.datastructures;

import com.google.common.collect.Lists;

import java.util.*;

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
         * Arrays.asList 返回的list底层是源数组
         */
        list3.set(3, "5");

        for (int i = 0; i < stringArray.length; i++) {
            System.out.print("stringArray" + i + ":" + stringArray[i] + " ");
        }
        System.out.println();
        System.out.println("list3:" + list3);


        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(2);
        System.out.println("integerList is:" + integerList);

        /**
         * Collection.toArray() 方法返回的是当前集合的拷贝,修改却不会修改源信息
         */
        Object[] objects = integerList.toArray();
        objects[2] = 3;

        integerList.set(0, 2);
        System.out.println("integerList after set is:" + integerList);

        for (int i = 0; i < objects.length; i++) {
            System.out.print("object" + (i + 1) + ":" + objects[i] + " ");
        }

        List<Integer> intArraySort = Lists.newArrayList();
        intArraySort.add(1);
        intArraySort.add(2);
        intArraySort.add(3);
        intArraySort.add(5);
        intArraySort.add(0);
        System.out.println();
        System.out.println("排序前:" + intArraySort);
        rankSort(intArraySort);
        System.out.println("排序后:" + intArraySort);


    }

    private static void rankSort(List<Integer> lsts) {

        Collections.sort(lsts, (x, y) -> {
            if (x > y) {
                return -1;
            } else if (x < y) {
                return 1;
            } else {
                return 0;
            }
        });
    }


}
