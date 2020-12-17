package com.example.demo_2020_1211.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class loginController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/findUser")   //查找数据库所有数据
    public List<loginUser> findUser(){
        //loginUser save = userRepository.save(loginUser);
        List<loginUser> check = userRepository.findAll();
        return check;
    }

    @GetMapping("/saveUser") //增加进入数据库
    public String saveUser(){
        String userName = "lisi";
        String password = "12345";
        ArrayList userlist = new ArrayList();
        loginUser ll = new loginUser();
        ll.setUserName(userName);
        ll.setPassword(password);
        userlist.add(ll);
        userRepository.saveAll(userlist);
        return "ok";
    }

    public void test(){
    }
}
