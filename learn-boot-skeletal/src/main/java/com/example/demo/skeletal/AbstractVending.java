package com.example.demo.skeletal;

/**
 * Created by hexinquan on 2019/04/09.
 */
public abstract class AbstractVending implements Ivending{
    public void start(){
        System.out.println("start vending machine ...");
    }
    //public abstract void chooseProduct();
    public void stop(){
        System.out.println("stop vending machine ...");
    }
    public void process(){
        start();
        chooseProduct();
        stop();
    }
}
