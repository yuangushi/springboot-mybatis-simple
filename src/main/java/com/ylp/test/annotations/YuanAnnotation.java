package com.ylp.test.annotations;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD,ElementType.TYPE})
public @interface YuanAnnotation {
    String value() default "";
}
