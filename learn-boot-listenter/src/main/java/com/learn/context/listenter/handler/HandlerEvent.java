package com.learn.context.listenter.handler;

import com.learn.context.listenter.ApplicationEvenDemo;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Created by hexinquan on 2018/12/17.
 */
@Component
public class HandlerEvent {
    @EventListener(ApplicationEvenDemo.class)
    public void handlerEvent(ApplicationEvenDemo event){
        System.out.println("接收了事件："+event.name);
    }
    @EventListener(ContextClosedEvent.class)
    public  void handlerEvent(ContextClosedEvent closedEvent){
        System.out.println("context close:"+closedEvent.toString());
    }
}
