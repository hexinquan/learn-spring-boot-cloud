package com.learn.juc.demo;

/**
 * Created by hexinquan on 2018/12/26.
 * <p>
 * 模拟 cas 算法案例
 */
public class TestCompareAndSwap {

    public static void main(String[] args) {
        final CompareAndSwap compareAndSwap = new CompareAndSwap();
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    int expectedValue = compareAndSwap.get();
                    boolean b = compareAndSwap.compareAndSet(expectedValue, (int) (Math.random() * 1001));
                    System.out.println(b);
                }
            }).start();
        }
    }


}

class CompareAndSwap {
    private int value;

    //获取内存值
    public synchronized int get() {
        return value;
    }

    //比较
    public synchronized int compareAndSwap(int expecteValue, int newValue) {
        int oldValue = value;
        if (oldValue == expecteValue) {
            this.value = newValue;
        }
        return oldValue;
    }

    //设置
    public synchronized boolean compareAndSet(int expectedValue, int newValue) {
        return expectedValue == compareAndSwap(expectedValue, newValue);
    }
}