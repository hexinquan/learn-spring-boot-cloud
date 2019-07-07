package com.learn.juc.demo;

/**
 * Created by hexinquan on 2019/03/29.
 * 题目判断打印 "one" or "two"
 * 线程8锁
 *  1.两个普通同步方法,两个线程，打印?  one -> two
 *  2.两个普通同步方法 ,getOne 添加 Threed.sleep()，打印? one-> two
 *  3.共三个方法,两个普通同步方法一个普通方法getThree() ,getOne 添加 Threed.sleep()，打印? threed -> one-> two
 *  4.两个普通同步方法,两个Number对象,两个线程分别调用不同Number,getOne() 添加 Threed.sleep(), 打印？ two -> one
 *  5.两个同步方法,一个为静态同步方法getOne() 添加 Threed.sleep(),一个普通同步方法getTwo() ,一个对象Number,打印？two -> one
 *  6.两个静态同步方法, getOne() 添加 Threed.sleep() , 一个对象Number ,打印？one -> two
 *  7. 一个静态方法getOne() 添加Threed.Sleep,一个普通同步方法 ,两个Number对象，打印? two -> one
 *  8.两个静态同步方法,getOne() 添加Threed.Sleep ,两个Number对象,打印? one -> two
 *
 *  结论：
 *  1.非静态同步方法的锁为 this , 静态同步锁为 对应的Class 实例
 *  2.某一时刻内,只能有一个线程持有锁,无论几个方法
 */
public class TestThread8Monitor {
    public static void main(String[] args) {
        Number number = new Number();
        Number number2 = new Number();
        new Thread(new Runnable() {
            @Override
            public void run() {
                number.getOne();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                number2.getTwo();
               // number.getTwo();
            }
        }).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                number.getThree();
//            }
//        }).start();
    }
}

class Number{
    public static synchronized void getOne(){ //锁为Number.class实例
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){

        }
        System.out.println("one");
    }
    public static  synchronized void getTwo(){
        System.out.println("two");
    }
//    public   synchronized void getTwo(){ //非静态方法的锁为this
//        System.out.println("two");
//    }
    public void getThree(){ //普通方法没有和同步方法有竞争关系
        System.out.println("Threed");
    }

}
