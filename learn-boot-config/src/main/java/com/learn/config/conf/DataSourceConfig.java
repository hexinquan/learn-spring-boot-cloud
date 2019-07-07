package com.learn.config.conf;

import com.learn.config.properties.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hexinquan on 2018/12/13.
 */
@Configuration
public class DataSourceConfig {
    @Bean
    @ConfigurationProperties(prefix = "hexinquan.datasource")
    public DataSourceProperties buildDataConfig(){
        return new DataSourceProperties();
    }
}
