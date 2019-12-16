package com.xiangxue.jack.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Data
@Service
public class CircularRefB {

    @Value("xxxk")
    private String username;

    @Autowired
    private CircularRefA circularRefA;
}
