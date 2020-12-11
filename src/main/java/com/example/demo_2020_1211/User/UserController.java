package com.example.demo_2020_1211.User;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/save")
    public String save() {
        User user1 = new User("john", "男", 25);
        User user2 = new User("lucy", "女", 18);
        User user3 = new User("Tom", "男", 16);
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        userService.saveAll(users);
        return "保存成功";
    }

    @RequestMapping("/userName")
    public User getByUserName(String userName) {
        return userService.getUserByUserName(userName);
    }

    @RequestMapping("/userNameAndAge")
    public List<User> getByUserNameAndAge(String userName, Integer age) {
        return userService.getUserByUserNameAndAge(userName, age);
    }

    @RequestMapping("/userNameLike")
    public List<User> getByUserNameLike(String userName) {
        return userService.getUserByUserNameLike(userName);
    }
}

