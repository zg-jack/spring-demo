package com.xiangxue.jack.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

//不扫描有@Controller注解的类
@ComponentScan(value = "com.xiangxue.jack",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
})
public class SpringContainer {
}
