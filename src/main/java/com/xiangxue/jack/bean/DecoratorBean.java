package com.xiangxue.jack.bean;

import lombok.Data;

@Data
public class DecoratorBean {
    private String username;

    private String password;

    private String age;

    private String sex;

    public DecoratorBean(String age, String sex) {
        this.age = age;
        this.sex = sex;
    }
}
