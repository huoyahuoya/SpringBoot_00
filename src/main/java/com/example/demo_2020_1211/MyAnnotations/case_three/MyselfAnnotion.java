package com.example.demo_2020_1211.MyAnnotations.case_three;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
//该注解只用在方法上，用在其他地方的可以查看元注解的其他枚举值，不赘述
@Target(ElementType.METHOD)
public @interface MyselfAnnotion {
    //注解的变量支持基本数据类型，字符串，枚举，以及对应的数组类型
    String name() default "guanyu";
    int age() default 18;
    boolean isHero() default true;
    String[] bros() default {};
}
