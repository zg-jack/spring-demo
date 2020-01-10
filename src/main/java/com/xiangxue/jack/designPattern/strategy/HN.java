package com.xiangxue.jack.designPattern.strategy;

import org.springframework.stereotype.Component;

@Component
public class HN implements Province{

    private static String flag = "HN";

    @Override
    public boolean support(String flag) {
        return HN.flag.equalsIgnoreCase(flag);
    }

    @Override
    public String handler() {
        System.out.println("======HN处理类处理");
        return null;
    }
}
