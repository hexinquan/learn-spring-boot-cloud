package com.learn.boot.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by hexinquan on 2018/12/20.
 */
@WebListener(value = "myListener")
public class Mylistener implements ServletContextListener,HttpSessionListener,HttpSessionAttributeListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("监听器创建session连接");
    }

    public Mylistener(){

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("监听器servlet容器摧毁");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("监听器监听servlet容器启动");
    }
}
