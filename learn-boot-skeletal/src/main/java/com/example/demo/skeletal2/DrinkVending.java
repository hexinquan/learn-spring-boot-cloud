package com.example.demo.skeletal2;

/**
 * Created by hexinquan on 2019/04/09.
 */
//1.实现接口存在多个方法重复代码存在
public class DrinkVending extends VendingService implements Ivending{

    private class AbstractVendingDelegator extends AbstractVending{
        @Override
        public void chooseProduct() {
            System.out.println("product different soft drinks ...");
        }
    }
    AbstractVendingDelegator abstractVendingDelegator = new AbstractVendingDelegator();

    @Override
    public void start() {
        abstractVendingDelegator.start();
    }

    @Override
    public void chooseProduct() {
        abstractVendingDelegator.chooseProduct();
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
