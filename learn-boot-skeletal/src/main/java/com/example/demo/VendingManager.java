package com.example.demo;

import com.example.demo.skeletal.AbstractVending;
import com.example.demo.skeletal.CandyVending;
import com.example.demo.skeletal.DrinkVending;
import com.example.demo.skeletal.Ivending;

/**
 * Created by hexinquan on 2019/04/09.
 */
public class VendingManager {
    public static void main(String[] args) {
        //实现接口：缺点-》会存在多个重复的实现方法代码
//        Ivending candy = new CandyVending();
//        Ivending drink = new DrinkVending();
        //实现抽象类:优点-> 去除类接口的缺点
        /**
         * 这里我为抽象类提供了通用的代码，`CandyVending` 和 `DrinkVending` 都继承了 `AbstractVending`。这么做虽然消除了重复代码，但引入了一个新问题。
         *
         * `CandyVending` 和 `DrinkVending` 继承了 `AbstractVending`，由于 Java 不支持多重集成因此不能继承其他类。
         *
         * 假如要添加一个 `VendingServicing` 类，负责清洁和检查自动售货机。在这种情况下，由于已经继承了 `AbstractVending`，
         * 因此不能继承 `VendingServicing`。这里可以新建组合（composition），但是必须把 `VendingMachine` 传入该组合，
         * 这会让 `VendingServicing` 和 `VendingMachine` 产生强耦合。
         */
        AbstractVending candyVending = new CandyVending();
        AbstractVending drinkVending = new DrinkVending();
        candyVending.process();
        drinkVending.process();
    }
}
