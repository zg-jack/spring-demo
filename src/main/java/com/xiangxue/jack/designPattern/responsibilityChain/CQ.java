package com.xiangxue.jack.designPattern.responsibilityChain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("CQ1")
public class CQ implements Province{

    private static String flag = "CQ";

    private Province province;

    @Override
    public String handler(String flag) {

        System.out.println("==CQ被调用到了==");
        if(CQ.flag.equalsIgnoreCase(flag)) {
            System.out.println("======CQ处理类处理");
        } else {
            province.handler(flag);
        }
        return null;
    }
}
