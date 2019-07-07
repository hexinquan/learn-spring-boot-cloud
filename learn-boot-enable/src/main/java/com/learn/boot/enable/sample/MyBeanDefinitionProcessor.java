package com.learn.boot.enable.sample;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.List;

/**
 * Created by hexinquan on 2018/12/17.
 */
public class MyBeanDefinitionProcessor implements BeanPostProcessor {

    public List<String> getPackages() {
        return packages;
    }

    public void setPackages(List<String> packages) {
        this.packages = packages;
    }

    private List<String> packages;

//    @Override
//    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        return bean;
//    }

    @Override
    public Object postProcessBeforeInitialization(Object bean,String beanName){

        for (String pack: packages){
            if(bean.getClass().getName().startsWith(pack)){
                System.out.println("instance bean:"+bean.getClass().getName());
            }
        }
        return bean;
    }
}
