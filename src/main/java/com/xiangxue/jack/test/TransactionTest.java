package com.xiangxue.jack.test;

import com.xiangxue.jack.bean.ComponentScanBean;
import com.xiangxue.jack.pojo.ConsultConfigArea;
import com.xiangxue.jack.pojo.ZgGoods;
import com.xiangxue.jack.service.AccountService;
import com.xiangxue.jack.service.area.AreaService;
import com.xiangxue.jack.service.transaction.TransationService;
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
        area.setAreaCode("XJ83");
        area.setAreaName("XJ83");
        area.setState("1");
        bean.addArea(area);
    }

    @Test
    public void propagationTest() {
        String areaStr = "HN3";
        String goodsStr = "iphone 10";
        TransationService transationService = applicationContext.getBean(TransationService.class);
        ConsultConfigArea area = new ConsultConfigArea();
        area.setAreaCode(areaStr);
        area.setAreaName(areaStr);
        area.setState("1");

        ZgGoods zgGoods = new ZgGoods();
        zgGoods.setGoodCode(goodsStr);
        zgGoods.setGoodName(goodsStr);
        zgGoods.setCount(100);
        transationService.transation(area,zgGoods);
    }

    @Test
    public void accountServiceTest() {
        AccountService bean = applicationContext.getBean(AccountService.class);
        bean.queryAccount("d");
    }

}
