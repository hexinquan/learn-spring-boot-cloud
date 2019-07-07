package com.learn.boot.config.core;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hexinquan on 2018/12/17.
 */
@Configuration
public class DatasourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "datasource")
    public DatasourceProperties datasource(){
        return new DatasourceProperties();
    }
}
