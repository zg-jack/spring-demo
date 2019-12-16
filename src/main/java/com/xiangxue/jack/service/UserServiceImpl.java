package com.xiangxue.jack.service;

import com.xiangxue.jack.bean.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@DependsOn
//@Lazy
@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private Student student;

//    @Autowired
//    private AccountService accountService;

    @Override
    public String queryUser(String userId) {
        return "xxx";
    }
}
