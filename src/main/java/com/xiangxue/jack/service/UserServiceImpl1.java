package com.xiangxue.jack.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Primary
@Service
public class UserServiceImpl1 implements UserService {
    @Override
    public String queryUser(String userId) {
        System.out.println("UserServiceImpl1 ->" + userId);
        return "UserServiceImpl1 ->" + userId;
    }
}
