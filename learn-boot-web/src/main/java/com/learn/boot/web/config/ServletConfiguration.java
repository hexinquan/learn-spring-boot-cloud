package com.learn.boot.web.config;

import com.learn.boot.web.filter.MyFilter;
import com.learn.boot.web.listener.Mylistener;
import com.learn.boot.web.servlet.MyServlet;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

/**
 * Created by hexinquan on 2018/12/20.
 */
@SpringBootConfiguration
public class ServletConfiguration {
    @Bean
    public ServletRegistrationBean<MyServlet> servletRegistrationBean(){
        ServletRegistrationBean<MyServlet> bean = new ServletRegistrationBean<>();
        bean.setServlet(new MyServlet());
        bean.setUrlMappings(Arrays.asList("/my"));
        return bean;
    }
    @Bean
    public FilterRegistrationBean<MyFilter> filterRegistrationBean(){
        FilterRegistrationBean<MyFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new MyFilter());
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
    @Bean
    public ServletListenerRegistrationBean<Mylistener> listenerRegistrationBean(){
        ServletListenerRegistrationBean<Mylistener> bean = new ServletListenerRegistrationBean<>();
        bean.setListener(new Mylistener());
        bean.setOrder(1);
        return bean;
    }
}
