package com.xiangxue.jack.designPattern.responsibilityChain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("HN1")
public class HN implements Province{

    private static String flag = "HN";

    private Province province;

    @Override
    public String handler(String flag) {
        System.out.println("==HN被调用到了==");
        if(HN.flag.equalsIgnoreCase(flag)) {
            System.out.println("======HN处理类处理");
        } else {
            province.handler(flag);
        }
        return null;
    }
}
