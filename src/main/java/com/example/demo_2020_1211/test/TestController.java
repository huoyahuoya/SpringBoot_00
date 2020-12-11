package com.example.demo_2020_1211.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test")
    public String test(){
        System.out.println("测试开始");
        return "测试开始???";
    }
}
//http://localhost:8080/test/test