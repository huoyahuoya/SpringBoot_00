package com.example.demo_2020_1211.MyAnnotations.case_four;

import com.example.demo_2020_1211.MyAnnotations.case_three.MyselfAnnotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyAnnotionTestController{

    @Autowired
    private MyAnnotionTestService myAnnotionTestService;

    @RequestMapping("/test/aop")
    @MyselfAnnotion
    public void testMyAnnotion5(){
        System.out.println("我来自Controller层，我用来测试自定义注解");
        myAnnotionTestService.testAopAnnotion();
    }

}