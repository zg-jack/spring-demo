package com.xiangxue.jack.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class CircularRefA {

    public CircularRefA() {
        System.out.println("============CircularRefA()===========");
    }

    @Autowired
    private CircularRefB circularRefB;
}
