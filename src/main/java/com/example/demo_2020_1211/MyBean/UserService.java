package com.example.demo_2020_1211.MyBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(){
        if (userRepository==null){
            System.out.println("why null");
        }
        userRepository.save();
    }
}
