package com.xiangxue.jack.config;

import com.xiangxue.jack.bean.PropertyBean;
import com.xiangxue.jack.bean.PropertyClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public PropertyBean propertyBean() {
        PropertyClass propertyClass = propertyClass();
        return new PropertyBean();
    }

    @Bean
    public PropertyClass propertyClass() {
        return new PropertyClass();
    }
}
