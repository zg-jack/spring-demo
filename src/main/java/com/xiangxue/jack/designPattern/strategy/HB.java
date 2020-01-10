package com.xiangxue.jack.designPattern.strategy;

import org.springframework.stereotype.Component;

@Component
public class HB implements Province{

    private static String flag = "HB";

    @Override
    public boolean support(String flag) {
        return HB.flag.equalsIgnoreCase(flag);
    }

    @Override
    public String handler() {
        System.out.println("======HB处理类处理");
        return null;
    }
}
