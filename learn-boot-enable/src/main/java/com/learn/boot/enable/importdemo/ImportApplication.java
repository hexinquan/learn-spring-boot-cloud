package com.learn.boot.enable.importdemo;

import com.learn.boot.enable.annotation.EnableScanner;
import com.learn.boot.enable.importdemo.importselect.BeanDefinitionRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * Created by hexinquan on 2018/12/17.
 */
@SpringBootApplication
//@Import(DemoImportSelect.class)
@EnableScanner(packages = {"com.learn.boot.enable.importdemo.model"}) //启用自定义注解启动
//@Import(BeanDefinitionRegister.class)
public class ImportApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(ImportApplication.class, args);
        //System.out.println(context.getBean("user"));
        //System.out.println(context.getBean("book"));
        context.close();
    }
}
