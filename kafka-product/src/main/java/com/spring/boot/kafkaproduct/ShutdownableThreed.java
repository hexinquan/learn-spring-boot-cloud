package com.spring.boot.kafkaproduct;

/**
 * Created by hexinquan on 2019/01/20.
 */
public abstract class ShutdownableThreed extends Thread{
    public abstract void doWork();
}
