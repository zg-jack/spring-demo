package com.xiangxue.jack.bean;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class PostConstructDemo {

    @PostConstruct
    public void init() {
        System.out.println("=======PostConstructDemo.init========");
    }

    @PreDestroy
    public void destory() {
        System.out.println("=======PostConstructDemo.destory========");
    }
}
