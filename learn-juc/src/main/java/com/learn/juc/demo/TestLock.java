package com.learn.juc.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hexinquan on 2019/03/25.
 * 一. 用于解决多线程安全问题的的方式:
 *  synchronized  :隐式锁
 *  1. 同步代码快 synchronized
 *
 *  2. 同步方法 synchronized method
 *
 *  jdk 1.5之后
 *
 *  3.同步锁Lock
 *  注释: 是一个显示锁,需要通过lock()方法上锁 ,必须通过unlock()方法进行释放锁
 */
public class TestLock {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(ticket,"1号窗口").start();
        new Thread(ticket,"2号窗口").start();
        new Thread(ticket,"3号窗口").start();

    }
}
class Ticket implements Runnable{
    private int tick = 100;
    private Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            lock.lock();
            try{
                if(tick>0){
                    Thread.sleep(100);
                    System.out.println(Thread.currentThread().getName()+" 完成售票,余票为:"+ -- tick);
                }
            }catch (InterruptedException e){
                System.out.println(e.getStackTrace());
            }
            finally {
                lock.unlock(); //释放锁
            }
        }
      //  ticks();
    }
    //可以达到同样效果
//    public synchronized void ticks(){
//        while (tick>0){
//            try{
//                Thread.sleep(200);
//                System.out.println(Thread.currentThread().getName()+" 完成售票,余票为:"+ -- tick);
//            }catch (InterruptedException e){
//
//            }
//        }
//    }
}
