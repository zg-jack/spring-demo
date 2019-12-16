package com.xiangxue.jack.bean;

public class FactoryBean {

    public Object factoryMethod(/*String id,List param*/) {
        System.out.println("=========factoryMethod=========");
        return new PropertyClass();
    }
}
