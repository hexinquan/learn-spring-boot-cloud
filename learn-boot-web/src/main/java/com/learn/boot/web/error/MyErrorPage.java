package com.learn.boot.web.error;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * Created by hexinquan on 2018/12/20.
 */
@Component
public class MyErrorPage implements ErrorPageRegistrar {
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage errorPage =new ErrorPage(HttpStatus.NOT_FOUND,"/404.html"); //404
        ErrorPage errorPage1 =new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500.html"); //404
        registry.addErrorPages(errorPage,errorPage1);
    }
}
