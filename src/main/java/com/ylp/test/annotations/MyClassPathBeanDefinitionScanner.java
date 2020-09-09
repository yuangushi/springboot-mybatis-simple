package com.ylp.test.annotations;

import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;

import java.util.Set;

public class MyClassPathBeanDefinitionScanner extends ClassPathBeanDefinitionScanner {
    public MyClassPathBeanDefinitionScanner(BeanDefinitionRegistry registry,boolean useDefaultSet) {
        super(registry,useDefaultSet);
    }

    public void registerFilters(){
        addIncludeFilter(new AnnotationTypeFilter(YuanAnnotation.class));
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        return super.doScan(basePackages);
    }
}
