package com.xiangxue.jack.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/*
* 如果需要在一个类实例化以后去做一些事情，那么就可以借助这个接口来完成
* */
public class InitMethodBean implements InitializingBean,BeanNameAware {

    @PostConstruct
    public void postConstruct() {
        System.out.println("========InitMethodBean.postConstruct()===");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("========InitMethodBean类实例化完成以后会调到===");
    }

    public void initMethod() {
        System.out.println("=======InitMethodBean.initMethod()=========");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("=========beanName:" + name);
    }
}
