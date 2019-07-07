package com.learn.juc.demo;

import java.util.concurrent.CountDownLatch;

/**
 * Created by hexinquan on 2019/03/22.
 *
 * 闭锁 : 闭锁,在完成某些运算时，只有其它线程的运算全部完成,当前运算才继续执行
 *  假如多个线程并发操作，需要计算执行总时间
 *  假如不同的线程需要去统计不同的库的总数或者不同库的销售平均值 等应用场景
 */
public class TestCountDownLatch {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(5);
        LatchDemo latchDemo = new LatchDemo(latch);
        long start = System.currentTimeMillis();
        for (int i =0;i<5;i++){
            new Thread(latchDemo).start();
        }
        try {
            latch.await();
        }catch (InterruptedException e){

        }
        long end = System.currentTimeMillis();
        System.out.println("耗时为:"+(end - start));
    }

}
class LatchDemo implements Runnable{
    private CountDownLatch latch;
    public LatchDemo(CountDownLatch latch){
        this.latch =latch;
    }
    @Override
    public void run() {
        synchronized (this){
            try {
                for (int i =0;i<5000; i++){
                    if(i%2 == 0){
                        System.out.println(i);
                    }
                }
            }finally {
                latch.countDown();
            }
        }
    }
}
