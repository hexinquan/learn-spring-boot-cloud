package com.learn.boot.enable;

import com.learn.boot.enable.annotation.EnableScanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync

public class EnableApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(EnableApplication.class, args);
        Runnable bean = context.getBean(Runnable.class);
        System.out.println("-----------start------------");
        bean.run();
        System.out.println("-----------end  ------------");
        context.close();
    }

}

