package com.spring.boot.kafkaproduct.pool;

import com.spring.boot.kafkaproduct.ShutdownableThreed;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hexinquan on 2019/01/20.
 */
@Component
public class KafkaConsumerPool {

    private static final Log LOG = LogFactory.getLog(KafkaConsumerPool.class);

    private ExecutorService executorService;

    @PostConstruct
    void init(){
        executorService = Executors.newFixedThreadPool(10);
    }

    public void SubmitConsumerPool(ShutdownableThreed shutdownableThreed){
        executorService.execute(shutdownableThreed);
    }

    @PreDestroy
    void fin(){

    }
    public void shutdown(){
        if(executorService != null){
            executorService.shutdown();
        }
        try {
            if(executorService.awaitTermination(5000,TimeUnit.MILLISECONDS)){
                LOG.info("Time out waiting for consumer threads to shut down ,exiting uncleanly");
            }
        }catch (InterruptedException e){
           LOG.error("InterruptedException during  shutdown,exiting uncleanly...  ");
        }
    }
}
