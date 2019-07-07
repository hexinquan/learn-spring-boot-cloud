package com.learn.boot.bean.core.config;

import com.learn.boot.bean.core.domain.Order;
import com.learn.boot.bean.core.domain.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hexinquan on 2018/12/17.
 */

@Configuration
public class BeanConfiguration {
    @Bean
    public Order createOrder(){
        return new Order();
    }
    @Bean
    public Product cretaeProduct(){
        return new Product();
    }
}
