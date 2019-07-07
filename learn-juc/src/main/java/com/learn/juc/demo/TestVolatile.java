package com.learn.juc.demo;

/**
 * Created by hexinquan on 2018/12/26.
 * 一. volatile  关键字:当多个线程进行操作共享数据时,可以保证内存中的数据可见。
 *               相对于synchronized 是一种较为轻量级的同步策略.
 *               volatile修饰之后jvm不会重排序
 *              1.1 但是 synchronized 具备排斥性  其中一个线程获取一个锁其它线程需等到释放锁之后才可操作
 *  注意：
 *     1.volatile 不具备 互斥性 因为是在主内存完成
 *     2.volatile 不能保证变量原子性
 *
 *     i++ 原子性问题
 *     步骤：int temp = i; i = i +1; i =temp;
 */
public class TestVolatile {
    public static void main(String[] args) {
            ThreadDemo threadDemo = new ThreadDemo();
            new Thread(threadDemo).start();
            while (true){
//                synchronized (threadDemo){
//                    if(threadDemo.isFalg()){
//                        System.out.println("-------");
//                        break;
//                    }
               // synchronized (threadDemo){
                    if(threadDemo.isFalg()){
                        System.out.println("-------");
                        break;
                    }
               // }

            }
    }
}
class ThreadDemo implements Runnable{

    public boolean isFalg() {
        return falg;
    }

    public void setFalg(boolean falg) {
        this.falg = falg;
    }

    private volatile boolean falg =false;

    @Override
    public void run() {
        try{
            Thread.sleep(200);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        falg =true;
        System.out.println("falg ="+isFalg());
    }
}