package com.xiangxue.jack.designPattern.strategy;

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

        beansOfType.forEach((k,v) -> {
            if(v.support(flag)) {
                v.handler();
            }
        });
    }


    public void test2() {
        String flag = "HB";

        if("HB".equalsIgnoreCase(flag)) {

        } else if("HN".equalsIgnoreCase(flag)) {

        } else if("HN".equalsIgnoreCase(flag)) {

        } else if("HN".equalsIgnoreCase(flag)) {

        } else if("HN".equalsIgnoreCase(flag)) {

        } else if("HN".equalsIgnoreCase(flag)) {

        } else if("HN".equalsIgnoreCase(flag)) {

        } else if("HN".equalsIgnoreCase(flag)) {

        } else if("HN".equalsIgnoreCase(flag)) {

        } else if("HN".equalsIgnoreCase(flag)) {

        } else if("HN".equalsIgnoreCase(flag)) {

        } else if("HN".equalsIgnoreCase(flag)) {

        } else if("HN".equalsIgnoreCase(flag)) {

        } else if("HN".equalsIgnoreCase(flag)) {

        }
    }
}
