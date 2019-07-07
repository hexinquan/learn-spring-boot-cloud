package com.learn.juc.demo;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by hexinquan on 2019/03/28.
 *  读写锁
 *  读/写需要互斥
 *  读读不需要互斥
 */
public class TestReadWriteLockDemo {

    public static void main(String[] args) {
        ReadWriteLockTest readWriteLockTest = new ReadWriteLockTest();
        new Thread(new Runnable(){
            @Override
            public void run() {
                readWriteLockTest.set( (int) (Math.random()* 1000));
            }
        },"写").start();
        for (int i = 1; i <= 50; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    readWriteLockTest.get();
                }
            },"读"+i).start();
        }
    }

}
class ReadWriteLockTest{
    private int number = 0 ;
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void get(){
        try {
            readWriteLock.readLock().lock();
            System.out.println(Thread.currentThread().getName()+":"+number);
        }finally {
            readWriteLock.readLock().unlock();
        }
    }
    public void set(int number){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName());
            this.number = number;
        }finally {
            readWriteLock.writeLock().unlock();
        }


    }
}
