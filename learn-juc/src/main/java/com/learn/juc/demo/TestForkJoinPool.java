package com.learn.juc.demo;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by hexinquan on 2019/04/17.
 */
public class TestForkJoinPool {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> forkJoinTask = new ForkJoinSumCalculate(0L,100000000L);
        Instant start = Instant.now();
        Long invoke = forkJoinPool.invoke(forkJoinTask);
        Instant end = Instant.now();
        System.out.println("耗时:"+Duration.between(start,end).toMillis());
        System.out.println(invoke);
    }

}
//实现线程任务类
class ForkJoinSumCalculate extends RecursiveTask<Long>{

    private Long start;
    private Long end;
    private static final Long THURSHOLD = 10000L;

    public ForkJoinSumCalculate(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if(length<= THURSHOLD){
            long sum = 0L;
            for (long i = start; i <end; i++) {
                sum +=i;
            }
            return sum;
        }
        else {
            long middle = (start + end) /2 ;
            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start,middle);
            left.fork();
            ForkJoinSumCalculate  right = new ForkJoinSumCalculate(middle+1,end);
            right.fork();
            return left.join() + right.join();

        }
    }
}