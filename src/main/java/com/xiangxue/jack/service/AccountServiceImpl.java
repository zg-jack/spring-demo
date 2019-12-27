package com.xiangxue.jack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    UserService userService;

    @Override
    public String queryAccount(String id) {
        System.out.println("==========AccountServiceImpl.queryAccount");
        return "==========AccountServiceImpl.queryAccount";
    }
}
