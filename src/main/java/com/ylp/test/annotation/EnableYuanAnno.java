package com.ylp.test.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
@Import(YuanImportSelector.class)
public @interface EnableYuanAnno {
}
