package com.xch.annontion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author xiech
 * @create 2020-01-16 16:08
 */
@Target(value =ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddAnnontion {

    String name() default "默认名称";

    int age() default 0;

    String [] arrays() ;
}
