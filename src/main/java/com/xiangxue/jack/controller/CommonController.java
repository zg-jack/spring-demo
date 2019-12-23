package com.xiangxue.jack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    ApplicationContext applicationContext;

//    @Autowired
//    RequestSessionBean requestSessionBean;

    @RequestMapping("/index")
    public void index() {
        System.out.println(applicationContext.getBean("requestSessionBean"));
    }
}
