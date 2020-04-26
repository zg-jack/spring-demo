package com.xiangxue.jack.beanDefinition;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class XX implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if(event instanceof ContextRefreshedEvent) {
            //这里实例化mq的类，用getBean
        }
    }
}
