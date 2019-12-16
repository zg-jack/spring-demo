package com.xiangxue.jack.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

//@Service
public class InstantiationAwareBeanPostProcessorDemo implements InstantiationAwareBeanPostProcessor {
    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return false;
    }
}
