package com.learn.boot.enable.importdemo.importselect;

import com.learn.boot.enable.importdemo.model.Book;
import com.learn.boot.enable.importdemo.model.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by hexinquan on 2018/12/17.
 * 这个注册装配器是可以注册属性值进去，与import的区别
 */
public class BeanDefinitionRegister implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        BeanDefinitionBuilder bdbUser = BeanDefinitionBuilder.rootBeanDefinition(User.class);
        beanDefinitionRegistry.registerBeanDefinition("user",bdbUser.getBeanDefinition());
        BeanDefinitionBuilder bdbBook = BeanDefinitionBuilder.rootBeanDefinition(Book.class);
        beanDefinitionRegistry.registerBeanDefinition("book",bdbBook.getBeanDefinition());

    }
}
