package com.learn.boot.web.config;

import com.learn.boot.web.interceptor.MyInteceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Created by hexinquan on 2018/12/20.
 */
@SpringBootConfiguration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInteceptor());
    }
}
