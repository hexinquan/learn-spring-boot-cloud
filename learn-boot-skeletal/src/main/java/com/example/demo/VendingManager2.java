package com.example.demo;

import com.example.demo.skeletal2.CandyVending;
import com.example.demo.skeletal2.DrinkVending;
import com.example.demo.skeletal2.Ivending;
import com.example.demo.skeletal2.VendingService;

/**
 * Created by hexinquan on 2019/04/09.
 */
public class VendingManager2 {
    public static void main(String[] args) {
        Ivending candy = new CandyVending();
        Ivending drink = new DrinkVending();
        candy.process();
        drink.process();
        if(drink instanceof VendingService){
            VendingService vendingService = (VendingService)drink;
            vendingService.service();
        }
    }
}
