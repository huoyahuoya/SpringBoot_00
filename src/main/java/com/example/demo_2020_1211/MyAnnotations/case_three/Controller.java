package com.example.demo_2020_1211.MyAnnotations.case_three;

import org.springframework.web.bind.annotation.RequestMapping;

public class Controller {

    @RequestMapping("/testMyselfAnno/no")
    @MyselfAnnotion(name = "guanyu", age = 50)
    public void testMyAnnotion1(){
        System.out.println("虽然是关羽，但是年龄大了，没通过校验");
    }

    @RequestMapping("/yes")
    @MyselfAnnotion(name = "guanyu", age = 50)
    public void testMyAnnotion2(){
        System.out.println("虽然有注解，但是路径不属于拦截范围，通过校验,进入方法体");
    }

    @RequestMapping("/testMyselfAnno/liubei/no")
    @MyselfAnnotion(name = "liubei", age = 48)
    public void testMyAnnotion3(){
        System.out.println("不是关羽，无法通过校验");
    }

    @RequestMapping("/testMyselfAnno/defaultyes")
    @MyselfAnnotion
    public void testMyAnnotion4(){
        System.out.println("注解默认值是关羽，而且很年轻，通过校验，进入方法体");
    }
}
