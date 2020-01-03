package com.xiangxue.jack.controller;

import com.xiangxue.jack.service.area.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/common")
public class CommonController {

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private AreaService areaService;

//    @Autowired
//    RequestSessionBean requestSessionBean;

    @RequestMapping("/index")
    public void index() {
        System.out.println(applicationContext.getBean("requestSessionBean"));
    }

    @RequestMapping("/query1")
    public @ResponseBody String query1() {
        return areaService.queryAreaFromRedisOne(null);
    }

    @RequestMapping("/query2")
    public @ResponseBody String query2() {
        return areaService.queryAreaFromRedisTow(null);
    }
}
