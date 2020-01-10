package com.xiangxue.jack.designPattern.strategy;

import org.springframework.stereotype.Component;

@Component
public class XJ implements Province{

    private static String flag = "XJ";

    @Override
    public boolean support(String flag) {
        return XJ.flag.equalsIgnoreCase(flag);
    }

    @Override
    public String handler() {
        System.out.println("======XJ处理类处理");
        return null;
    }
}
