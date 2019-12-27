package com.xiangxue.jack.targetSource;

import org.springframework.aop.framework.autoproxy.target.AbstractBeanFactoryBasedTargetSourceCreator;
import org.springframework.aop.target.AbstractBeanFactoryBasedTargetSource;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyTargetSourceCreator extends AbstractBeanFactoryBasedTargetSourceCreator {
    @Override
    protected AbstractBeanFactoryBasedTargetSource createBeanFactoryBasedTargetSource(Class<?> beanClass, String beanName) {

        if (getBeanFactory() instanceof ConfigurableListableBeanFactory) {
            BeanDefinition definition =
                    ((ConfigurableListableBeanFactory) getBeanFactory()).getBeanDefinition(beanName);

            if(beanName.equalsIgnoreCase("userServiceImpl1")) {
                return new MyTargetSource();
            }
        }

        return null;
    }
}
