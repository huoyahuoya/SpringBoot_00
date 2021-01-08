package com.example.demo_2020_1211.bean.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bean")
public class HelloController {

    @Autowired
    String hello;

    @Autowired
    String hello_1;

    @Autowired
    String hello_2;

    @RequestMapping("/test")
    public String test() {
        return "hello_2 = "+ hello_2;
    }
}
