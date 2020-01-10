package com.xiangxue.jack.designPattern.strategy;

import org.springframework.stereotype.Component;

@Component
public class SC implements Province{

    private static String flag = "SC";

    @Override
    public boolean support(String flag) {
        return SC.flag.equalsIgnoreCase(flag);
    }

    @Override
    public String handler() {
        System.out.println("======SC处理类处理");
        return null;
    }
}
