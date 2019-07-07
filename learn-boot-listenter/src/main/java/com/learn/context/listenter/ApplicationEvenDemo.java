package com.learn.context.listenter;

import org.springframework.context.ApplicationEvent;

/**
 * Created by hexinquan on 2018/12/17.
 */
public class ApplicationEvenDemo extends ApplicationEvent  {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String name;

    public ApplicationEvenDemo(String name){
        super(name);
        this.name =name;
    }
}
