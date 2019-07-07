package com.learn.context.listenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ListenterApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ListenterApplication.class, args);
        context.publishEvent(new ApplicationEvenDemo("hexinquan"));
        context.close();
    }

}

