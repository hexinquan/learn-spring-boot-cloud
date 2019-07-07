package com.learn.juc.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hexinquan on 2019/03/26.
 * 类似object wait 以及 notifyall 线程通讯以及同步
 */
public class TestLockCondition {
    public static void main(String[] args) {
        Opter opter =new Opter();
        ProductorCount productorCount = new ProductorCount(opter);
        ConsumerCount consumerCount = new ConsumerCount(opter);
        new Thread(productorCount,"生产者A").start();
        new Thread(productorCount,"生产者B").start();
        new Thread(productorCount,"生产者C").start();
        new Thread(consumerCount,"消费者A").start();
        new Thread(consumerCount,"消费者B").start();
        new Thread(consumerCount,"消费者C").start();
    }
}
class Opter {
    private int count = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    public void put(){
        lock.lock();
        try {
            while (count>=1){
                System.out.println("大于0");
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+":"+count++);
            condition.signalAll();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            lock.unlock();
        }
    }
    public void get(){
        lock.lock();
        try {
            while(count<=0){
                System.out.println("小于0");
                condition.await();
            }
            System.out.println(Thread.currentThread().getName()+":"+count--);
            condition.signalAll();
        }catch (Exception e){
            System.out.println(e);
        }finally {
            lock.unlock();
        }
    }
}
class ProductorCount implements Runnable{

    private Opter opter;

    public ProductorCount(Opter opter) {
        this.opter = opter;
    }

    @Override
    public void run() {
        for (int i = 0;i<=10;i++){
            opter.put();
        }
    }
}
class ConsumerCount implements Runnable{

    private Opter opter;

    public ConsumerCount(Opter opter) {
        this.opter = opter;
    }

    @Override
    public void run() {
        for (int i = 0;i<=10;i++){
            opter.get();
        }
    }
}