package com.example.demo_2020_1211.MyBean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    UserService userService;

    @RequestMapping("/MyBean_test")
    public String MyBean_test(){
        userService.save();
        return "MyBean_test";
    }
}
