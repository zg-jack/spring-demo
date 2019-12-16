package com.xiangxue.jack.bean;

import lombok.Data;

@Data
public class ConstructorArgBean {

    private String username;

    private String password;

    public ConstructorArgBean(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "ConstructorArgBean{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
