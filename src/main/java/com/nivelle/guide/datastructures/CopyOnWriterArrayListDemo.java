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
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();

        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();

        CopyOnWriteMap copyOnWriteMap = new CopyOnWriteMap();
    }
}
