package com.boot.condition.learn;

import com.boot.condition.learn.converter.EncodingConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

@SpringBootApplication
public class BootConditionConfigApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BootConditionConfigApplication.class, args);
        Map<String,EncodingConverter> beansOfType = context.getBeansOfType(EncodingConverter.class);
        System.out.println(System.getProperty("file.encoding"));
        System.out.println(beansOfType);
       context.close();
    }

}

