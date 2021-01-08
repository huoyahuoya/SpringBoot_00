package com.example.demo_2020_1211.MyAnnotations.case_one;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ClassMethodAnnotation {
    Class c();
    String method();
}
