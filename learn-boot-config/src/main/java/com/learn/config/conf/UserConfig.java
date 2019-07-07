package com.learn.config.conf;

import com.learn.config.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hexinquan on 2018/12/13.
 */
@Configuration
public class UserConfig {
    @Bean
    public User buildUser(){
       return new User();
    }
}
