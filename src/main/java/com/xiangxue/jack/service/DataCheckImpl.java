package com.xiangxue.jack.service;

import org.springframework.stereotype.Service;

@Service
public class DataCheckImpl implements DataCheck {
    @Override
    public boolean check() {

        System.out.println("=======DataCheckImpl.check===进行权限省份校验");
        return false;
    }
}
