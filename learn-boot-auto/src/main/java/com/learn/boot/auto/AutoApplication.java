package com.learn.boot.auto;

import com.google.gson.Gson;
import com.learn.boot.bean.core.domain.Order;
import com.learn.boot.bean.core.domain.Product;
import com.learn.boot.config.core.DatasourceConfig;
import com.learn.boot.config.core.DatasourceProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@EnableAutoConfiguration(exclude = {BeanConfiguration.class}) //通过类排除配置类(必须是配置类)
//@EnableAutoConfiguration (excludeName = {"com.learn.boot.bean.core.domain.Product"}) //通过类全路径名称排除配置类(必须是配置类)
@SpringBootApplication
public class AutoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(AutoApplication.class, args);
        System.out.println(context.getBean(Order.class));
        System.out.println(context.getBean(Product.class));
        System.out.println(context.getBean(DatasourceConfig.class));
        System.out.println(context.getBean(DatasourceProperties.class).getDriverClassName());
        System.out.println(context.getBean("gson", Gson.class));
        context.close();
    }

}

