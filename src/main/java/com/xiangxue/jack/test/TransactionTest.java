package com.xiangxue.jack.test;

import com.xiangxue.jack.bean.ComponentScanBean;
import com.xiangxue.jack.pojo.ConsultConfigArea;
import com.xiangxue.jack.service.area.AreaService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;

public class TransactionTest {

    private ApplicationContext applicationContext;

    @Before
    public void before() {
        applicationContext = new AnnotationConfigApplicationContext(ComponentScanBean.class);
    }

    @Test
    public void test1() {
        AreaService bean = applicationContext.getBean(AreaService.class);
        Map param = new HashMap();
        param.put("areaCode","HB1");
        bean.queryAreaFromDB(param);
    }

    @Test
    public void addAreaTest() {
        AreaService bean = applicationContext.getBean(AreaService.class);
        ConsultConfigArea area = new ConsultConfigArea();
        area.setAreaCode("XJ13");
        area.setAreaName("XJ13");
        area.setState("1");
        bean.addArea(area);
    }
}
