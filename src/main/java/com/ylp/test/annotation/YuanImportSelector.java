package com.ylp.test.annotation;

import com.ylp.test.annotations.YuanAnnotation;
import com.ylp.test.entity.TestSelector;
import com.ylp.test.service.impl.UserServiceImpl;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class YuanImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        Map<String, Object> annotationAttributes = importingClassMetadata.getAnnotationAttributes(EnableYuanAnno.class.getName(), true);
        System.out.println("获取到的map是");
        annotationAttributes.forEach((k,v)->{
            System.out.println("key是"+k+",value是"+v);
        });

        return new String[]{TestSelector.class.getName()};
    }
}
