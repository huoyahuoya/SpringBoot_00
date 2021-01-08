package com.example.demo_2020_1211.MyBean;

import org.springframework.stereotype.Repository;

@Repository("userRepository")
public class UserRepositoryImps implements UserRepository{

    @Override
    public void save() {
        System.out.println("UserRepositoryImps save");
    }
}
