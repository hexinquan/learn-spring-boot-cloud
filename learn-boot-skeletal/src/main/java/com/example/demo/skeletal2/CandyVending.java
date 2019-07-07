package com.example.demo.skeletal2;

/**
 * Created by hexinquan on 2019/04/09.
 */
//骨架实现
public class CandyVending implements Ivending{
//实现抽象类可以减少对应一下注释的代码
public class AbstractVendingDelegator extends AbstractVending {
    //实现需要子类实现的方法
    @Override
    public void chooseProduct() {
        System.out.println("Product different candies ...");
    }
}
    AbstractVendingDelegator abstractVendingDelegator = new AbstractVendingDelegator();
    @Override
    public void chooseProduct() {
        abstractVendingDelegator.chooseProduct();
    }
    @Override
    public void start() {
        abstractVendingDelegator.start();
    }
    @Override
    public void stop() {
        abstractVendingDelegator.stop();
    }
    @Override
    public void process() {
        abstractVendingDelegator.process();
    }
}
