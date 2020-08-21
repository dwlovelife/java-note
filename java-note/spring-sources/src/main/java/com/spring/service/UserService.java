package com.spring.service;

import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Override
    public User createUser() {
        User user = new User();
        user.setAge(11);
        user.setName("Jack");
        return user;
    }

}
