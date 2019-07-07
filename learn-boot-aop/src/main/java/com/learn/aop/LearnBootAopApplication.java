package com.learn.aop;

import com.learn.aop.aspect.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication

public class LearnBootAopApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(LearnBootAopApplication.class, args);
        System.out.println(context.getBean(Book.class));
        context.close();
    }

}

