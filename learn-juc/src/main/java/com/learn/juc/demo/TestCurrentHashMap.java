package com.learn.juc.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by hexinquan on 2019/03/22.
 */
public class TestCurrentHashMap {

    public static void main(String[] args) {
        TestThread testThread = new TestThread();
        for (int i = 0; i<10;i++){
            new Thread(testThread).start();
        }
    }

}
 class TestThread implements Runnable{
    //private static List<String> list =  Collections.synchronizedList(new ArrayList<>());
     private static CopyOnWriteArrayList list = new CopyOnWriteArrayList();
    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }
    @Override
    public void run() {
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            list.add("AA");
        }
    }
}
