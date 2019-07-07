package com.learn.juc.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by hexinquan on 2019/03/22.
 * 创建执行线程的方式三:实现Callable 接口. 相较于实现Runnable 接口的方式，方法可以返回值,并且可以跑出异常
 * callable 需要与Futuretask 的实现类支持,用于接收运算接口.FutureTask 是Future接口的实现类
 */
public class TestCallable {
    public static void main(String[] args) {
        ThreadTest td = new ThreadTest();
        //1.执行Callable 方式,需要FutureTask 实现类的支持,用于接收运算结果
        FutureTask<Integer> result = new FutureTask<>(td);
        new Thread(result).start();
        //2.接收线程运算后的结果
        try {
            Integer sum = result.get(); //也可用做于闭锁
            System.out.println(sum);
            System.out.println("---------------------------");
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
    }

}
class ThreadTest implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            sum = sum + i;
        }
        return sum;
    }
}

