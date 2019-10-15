package com.nivelle.guide.datastructures;

import org.apache.kafka.common.utils.CopyOnWriteMap;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * CopyOnWriterArrayList
 *
 * @author fuxinzhong
 * @date 2019/06/16
 */
public class CopyOnWriterArrayListDemo {


    public static void main(String[] args) {

        /**
         *  1. 内部持有一个ReentrantLock lock = new ReentrantLock();
         *
         *  2. 底层是用volatile transient声明的数组 array
         *
         *  3. 读写分离，写时复制出一个新的数组，完成插入、修改或者移除操作后将新数组赋值给array
         */
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();

        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();

        CopyOnWriteMap copyOnWriteMap = new CopyOnWriteMap();

        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(2);
        System.out.println(copyOnWriteArrayList);

        Object element = copyOnWriteArrayList.get(1);
        System.out.println(element);
    }
}
