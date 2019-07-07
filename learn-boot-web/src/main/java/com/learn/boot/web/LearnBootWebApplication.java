package com.learn.boot.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
//@ServletComponentScan
public class LearnBootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnBootWebApplication.class, args);
    }

}

