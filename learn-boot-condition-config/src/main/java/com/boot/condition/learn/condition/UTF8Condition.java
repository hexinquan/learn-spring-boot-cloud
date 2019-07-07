package com.boot.condition.learn.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Created by hexinquan on 2018/12/13.
 */
public class UTF8Condition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String encoding = System.getProperty("file.encoding");
        if("utf-8".equals(encoding.toLowerCase())){
            return true;
        }
        return false;
    }
}
