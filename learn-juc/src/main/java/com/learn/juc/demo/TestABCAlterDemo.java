package com.learn.juc.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hexinquan on 2019/03/28.
 * 编写一个程序, 开启3个线程,这个三个线程的ID 分别为 A B C ,每个线程将自己的ID 在屏幕上打印 10 遍 ,要求的输出的结果 必须按顺序显示
 */
public class TestABCAlterDemo {
    public static void main(String[] args) {
        AlterDemo alterDemo = new AlterDemo();
        new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i = 1; i <=10; i++) {
                    alterDemo.loopA(i);
                }
            }
        },"A").start();
        new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i = 1; i <=10; i++) {
                    alterDemo.loopB(i);
                }
            }
        },"B").start();
        new Thread(new Runnable(){
            @Override
            public void run(){
                for (int i = 1; i <=10; i++) {
                    alterDemo.loopC(i);
                }
            }
        },"C").start();
    }
}
class AlterDemo{
    private  int  number = 1; //当前正在执行线程标记
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    /**
     *
     * @param totalLoop  //循环第几批
     */
    public void loopA(int totalLoop){
        lock.lock();
        try {
            //1.判断
            if(number != 1){
                condition1.await();
            }
            //2. 打印
            for (int i = 1; i <= 1; i++) {
                System.out.println(Thread.currentThread().getName()+" \t"+i+" \t"+totalLoop);
            }
            //3.唤醒
            number = 2;
            condition2.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    /**
     *
     * @param totalLoop  //循环第几批
     */
    public void loopB(int totalLoop){
        lock.lock();
        try {
            //1.判断
            if(number != 2){
                condition2.await();
            }
            //2. 打印
            for (int i = 1; i <= 1; i++) {
                System.out.println(Thread.currentThread().getName()+" \t"+i+" \t"+totalLoop);
            }
            //3.唤醒
            number = 3;
            condition3.signal();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    /**
     *
     * @param totalLoop  //循环第几批
     */
    public void loopC(int totalLoop){
        lock.lock();
        try {
            //1.判断
            if(number != 3){
                condition3.await();
            }
            //2. 打印
            for (int i = 1; i <= 1; i++) {
                System.out.println(Thread.currentThread().getName()+" \t"+i+" \t"+totalLoop);
            }
            System.out.println("-----------------------------------------------------------");
            //3.唤醒
            number = 1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
