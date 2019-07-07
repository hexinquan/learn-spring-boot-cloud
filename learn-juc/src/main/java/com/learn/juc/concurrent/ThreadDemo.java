package com.learn.juc.concurrent;

/**
 * Created by hexinquan on 2018/12/26.
 */
public class ThreadDemo implements Runnable{

    public boolean isFalg() {
        return falg;
    }

    public void setFalg(boolean falg) {
        this.falg = falg;
    }

    private boolean falg =false;

    @Override
    public void run() {
        falg =true;
        System.out.println("falg ="+isFalg());
    }
}
