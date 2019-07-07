package com.learn.juc.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hexinquan on 2018/12/26.
 * 一, i++  的原子性问题 读-》改-》写
 * int i= 10
 * i = i++ ;
 * 底层是
 * int temp = i;
 * i = i + 1;
 * i = temp;
 * <p>
 * 二. 原子变量: jdk1.5之后java.util.concurrent.atomic 包下提供了原子变量包
 *           具备:
 *                1.volatile 保证内存可见性
 *                2.CAS(Compare-And-Swap) 算法保证数据的原子性
 *                  CAS算法是硬件对于并发操作共享数据的支持
 *                  CAS 包含了以下3个操作:
 *                       内存值 V
 *                       预估值 A
 *                       更新值 B
 *                       读取内存值判断是否预预估值相等，然后更新为B，否则什么操作都不做
 *                       V =  0 -> V=A
 *  CurrentHashMap 默认16个段(segment) 每个段里面的默认有16个都有一个linktable 链表 ,每个段都有独立的锁允许不同的线程并发访问 ,  并行的
 *
 */
public class TestAtomicDemo {

    public static void main(String[] args) {
        AtomicDemo atomicDemo = new AtomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(atomicDemo).start();
        }
    }
}
class AtomicDemo implements Runnable {

    //private int serialNumber = 0;  此声明变量为非原子变量

    private AtomicInteger serialNumber = new AtomicInteger(); //成员变量存在主内存, 跟integer包装类差不多

    public int getSerialNumber() {
        return serialNumber.getAndIncrement();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
            System.out.println(getSerialNumber());
        } catch (InterruptedException e) {
            System.out.println(e);
        }

    }
}