package com.learn.boot.enable.sample;

import com.learn.boot.enable.annotation.EnableScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by hexinquan on 2018/12/17.
 */
@SpringBootApplication
@EnableScanner(packages = {"com.learn.boot.enable.sample.model"})
public class BeanDefinitionProcessApp {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(BeanDefinitionProcessApp.class, args);
        context.close();
    }

}
