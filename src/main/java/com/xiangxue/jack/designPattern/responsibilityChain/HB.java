package com.xiangxue.jack.designPattern.responsibilityChain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("HB1")
public class HB implements Province{

    private static String flag = "HB";

    private Province province;

    @Override
    public String handler(String flag) {

        System.out.println("==HB被调用到了==");
        if(HB.flag.equalsIgnoreCase(flag)) {
            System.out.println("======HB处理类处理");
        } else {
            province.handler(flag);
        }
        return null;
    }
}
