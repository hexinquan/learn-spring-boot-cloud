package com.boot.condition.learn.config;

import com.boot.condition.learn.condition.GBKCondition;
import com.boot.condition.learn.condition.UTF8Condition;
import com.boot.condition.learn.converter.EncodingConverter;
import com.boot.condition.learn.converter.GBKEncodingConverter;
import com.boot.condition.learn.converter.UTF8EncodingConverter;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;

/**
 * Created by hexinquan on 2018/12/13.
 * 1。
 */
@SpringBootConfiguration
public class EncodingConverterConfig {
    @Bean
    @Conditional(value = UTF8Condition.class)
    public EncodingConverter createUTF8Converter(){
      return new UTF8EncodingConverter();
    };

    @Bean
    @Conditional(value = GBKCondition.class)
    public EncodingConverter createGBKConverter(){
        return new GBKEncodingConverter();
    };
}
