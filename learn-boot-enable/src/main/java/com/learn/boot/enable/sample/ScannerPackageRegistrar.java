package com.learn.boot.enable.sample;

import com.learn.boot.enable.annotation.EnableScanner;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hexinquan on 2018/12/17.
 */
public class ScannerPackageRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        String [] attrs =(String[])annotationMetadata
                .getAnnotationAttributes(EnableScanner.class.getName())
                .get("packages");
        List<String> packages = Arrays.asList(attrs);
        System.out.println(packages);
        BeanDefinitionBuilder bdb  = BeanDefinitionBuilder.rootBeanDefinition(MyBeanDefinitionProcessor.class);
        bdb.addPropertyValue("packages",packages);
        beanDefinitionRegistry.registerBeanDefinition(MyBeanDefinitionProcessor.class.getName(),bdb.getBeanDefinition());

    }
}
