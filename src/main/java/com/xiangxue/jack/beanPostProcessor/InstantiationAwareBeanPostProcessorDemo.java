package com.xiangxue.jack.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/*
* 可以使所有类不能ioc依赖注入
* */
//@Service
public class InstantiationAwareBeanPostProcessorDemo implements InstantiationAwareBeanPostProcessor {
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return false;
    }
}
