package com.xiangxue.jack.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Data
@Service
public class CircularRefC {

    public CircularRefC() {
        System.out.println("============CircularRefC()===========");
    }

    @Autowired
    private CircularRefA circularRefA;
}
