package com.xiangxue.jack.designPattern.responsibilityChain;

import com.xiangxue.jack.bean.ComponentScanBean;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class Test {

    private ApplicationContext applicationContext;

    @Before
    public void before() {
        applicationContext = new AnnotationConfigApplicationContext(ComponentScanBean.class);
    }

    @org.junit.Test
    public void test1() {

        String flag = "CQ";

        Map<String, Province> beansOfType = applicationContext.getBeansOfType(Province.class);

        CQ bean1 = (CQ)applicationContext.getBean("CQ1");
        HB bean2 = (HB)applicationContext.getBean("HB1");
        SC bean3 = (SC)applicationContext.getBean("SC1");
        HN bean4 = (HN)applicationContext.getBean("HN1");

        bean2.setProvince(bean1);
        bean3.setProvince(bean2);
        bean4.setProvince(bean3);
        bean1.setProvince(bean4);

        bean4.handler(flag);
    }
}
