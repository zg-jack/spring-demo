package com.xiangxue.jack.bean;

import org.springframework.beans.factory.support.MethodReplacer;

import java.lang.reflect.Method;

public class ReplaceClass implements MethodReplacer {
    @Override
    public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
        System.out.println("I am replace method-->reimplement!");
        return null;
    }
}
