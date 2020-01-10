package com.xiangxue.jack.designPattern.responsibilityChain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component("SC1")
public class SC implements Province{

    private static String flag = "SC";

    private Province province;

    @Override
    public String handler(String flag) {

        System.out.println("==SC被调用到了==");
        if(SC.flag.equalsIgnoreCase(flag)) {
            System.out.println("======SC处理类处理");
        } else {
            province.handler(flag);
        }
        return null;
    }
}
