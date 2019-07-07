package com.learn.boot.enable.importdemo.importselect;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Created by hexinquan on 2018/12/17.
 */
public class DemoImportSelect implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{"com.learn.boot.enable.importdemo.model.book","com.learn.boot.enable.importdemo.model.user"};
    }
}
