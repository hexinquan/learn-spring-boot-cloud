package com.learn.boot.enable.annotation;

import com.learn.boot.enable.sample.ScannerPackageRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(ScannerPackageRegistrar.class)
public @interface EnableScanner {
     String [] packages();
}
