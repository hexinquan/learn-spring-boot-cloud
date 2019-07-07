package com.learn.boot.enable.runnable;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Created by hexinquan on 2018/12/17.
 */
@Component
public class RunnableDemo implements Runnable{

    @Override
    @Async
    public void run() {
        for (int i=0;i<10;i++)
        {
            System.out.println(i);
            try {
                TimeUnit.SECONDS.sleep(1);
            }catch (Exception e){
                System.out.println(e);
            }

        }
    }
}
