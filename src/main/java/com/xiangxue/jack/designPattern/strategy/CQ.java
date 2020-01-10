package com.xiangxue.jack.designPattern.strategy;

import org.springframework.stereotype.Component;

@Component
public class CQ implements Province{

    private static String flag = "CQ";

    @Override
    public boolean support(String flag) {
        return CQ.flag.equalsIgnoreCase(flag);
    }

    @Override
    public String handler() {
        System.out.println("======CQ处理类处理");
        return null;
    }
}
