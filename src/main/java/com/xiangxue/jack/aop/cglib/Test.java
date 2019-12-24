package com.xiangxue.jack.aop.cglib;

public class Test {
    public static void main(String[] args) {
        UserService userService = (UserService)CglibBeanFactory.getInstance();
        System.out.println(userService.doSomething1("Jack"));
    }
}
