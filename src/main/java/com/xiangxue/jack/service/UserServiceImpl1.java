package com.xiangxue.jack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Lazy
@Primary
@Service
public class UserServiceImpl1 implements UserService {

    @Autowired
    AccountService accountService;

    @Override
    public String queryUser(String userId) {
        System.out.println("UserServiceImpl1 ->" + userId);
        return "UserServiceImpl1 ->" + userId;
    }

    @Override
    public void addxx(String id) {
        System.out.println("UserServiceImpl1 -> addxx");
    }
}
