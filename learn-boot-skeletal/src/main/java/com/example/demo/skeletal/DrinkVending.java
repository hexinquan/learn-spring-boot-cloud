package com.example.demo.skeletal;

/**
 * Created by hexinquan on 2019/04/09.
 */
//1.实现接口存在多个方法重复代码存在
//public class DrinkVending implements Ivending{
//实现抽象类可以减少对应一下注释的代码
public class DrinkVending extends AbstractVending{
//    @Override
//    public void start() {
//        System.out.println("start vending machine ...");
//    }

    @Override
    public void chooseProduct() {
        System.out.println("product different soft drinks ...");
    }

//    @Override
//    public void stop() {
//        System.out.println("stop vending machine ...");
//    }

//    @Override
//    public void process() {
//        start();
//        chooseProduct();
//        stop();
//    }
}
