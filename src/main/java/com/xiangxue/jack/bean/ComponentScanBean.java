package com.xiangxue.jack.bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@Service
//@Configuration
@ComponentScan(basePackages = {"com.xiangxue"})
@Import(OriginClass.class)
public class ComponentScanBean {

//    @Bean
//    public void xx() {
//        System.out.println("==");
//    }
}
