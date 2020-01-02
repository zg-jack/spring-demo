package com.xiangxue.jack.aop.aspectj;

import com.xiangxue.jack.annotation.TargetSource;
import com.xiangxue.jack.datasource.DynamicDataSourceHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(-1)
public class AspectDs {

    @Before(value = "@annotation(targetSource)",argNames = "joinPoint,targetSource")
    public void xx(JoinPoint joinPoint, TargetSource targetSource) {

        System.out.println("========AspectDs.xx");
        String value = targetSource.value();

        if(value != null && !"".equals(value)) {
            DynamicDataSourceHolder.getLocal().set(value);
        } else {
            DynamicDataSourceHolder.getLocal().set("ds1");
        }
    }
}
