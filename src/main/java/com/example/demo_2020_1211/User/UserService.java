package com.example.demo_2020_1211.User;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    @Transactional
    public void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }

    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public List<User> getUserByUserNameAndAge(String userName,Integer age){
        return userRepository.findByUserNameAndAge(userName, age);
    }

    public List<User> getUserByUserNameLike(String userName){
        return userRepository.findByUserNameLike(userName);
    }
}
