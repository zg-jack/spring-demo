package com.xiangxue.jack.factoryBean;

import org.springframework.beans.factory.FactoryBean;

//@Service
public class FactoryBeanDemo implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return new FactoryB();
    }

    @Override
    public Class<?> getObjectType() {
        return FactoryB.class;
    }
}
