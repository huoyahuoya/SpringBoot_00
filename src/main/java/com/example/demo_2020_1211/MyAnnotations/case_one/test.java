package com.example.demo_2020_1211.MyAnnotations.case_one;

public class test {

    @ClassMethodAnnotation(c=test.class,method="test1")
    public void test(){
        System.out.println("===test方法执行了！！！！！");
    }

    public void test1(){
        System.out.println("test1方法执行了！！！！！");
    }
}
