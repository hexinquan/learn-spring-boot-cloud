package com.learn.juc.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by hexinquan on 2019/03/29.
 *  线程池:提供了一个线程队列,队列中保存者所有等待状态的线程. 避免了创建与销毁额外开销,提高了响应的速度.
 *  线程池的体系结构:
 *        java.util.conccrent.Executor :负责线程的使用与调度的根接口
 *            --ExecutorService 子接口: 线程池的主要接口
 *               -- ThreadPoolExecutor 线程池的实现类
 *                  -- ScheduledExecutorService 子接口 负责线程的调度
 *                   -- ScheduledThreadPoolExecutor : 继承ThreadPoolExecutor , 实现ScheduledExecutorService
 *
 * 线程池工具:
 *    ExecutorService newFixedThreadPool() : 创建固定大小的线程池
 *    ExecutorService newCachedThreadPool() : 缓存线程池,线程池的数量不固定,可以根据需求自动的更改数量
 *    ExecutorService newSingleThreadExceutor :创建单个线程池 线程池中只有一个线程
 */
public class TestScheduledThreadPool{

    public static void main(String[] args) throws Exception {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Future<Integer> result = executorService.schedule(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    int num = new Random().nextInt(100);
                    System.out.println(Thread.currentThread().getName() + ":" + num);
                    return num;
                }
            }, 3, TimeUnit.SECONDS);
            System.out.println(result.get());
        }
        executorService.shutdown();
    }
}