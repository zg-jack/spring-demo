package com.xiangxue.jack.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelfAutowired {

    @Autowired
    private SelfAutowired selfAutowired;

    public void aa() {
        System.out.println(selfAutowired.selfAutowired);
        selfAutowired.bb();
    }

    public void bb() {
        System.out.println("==SelfAutowired.bb==");
    }
}
