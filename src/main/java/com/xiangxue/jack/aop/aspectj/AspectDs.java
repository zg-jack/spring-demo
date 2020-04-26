package com.xiangxue.jack.aop.aspectj;

import com.xiangxue.jack.annotation.TargetSource;
import com.xiangxue.jack.datasource.DynamicDataSourceHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(-1)
public class AspectDs {

    @Around(value = "@annotation(targetSource)",argNames = "joinPoint,targetSource")
    public Object xx(ProceedingJoinPoint joinPoint, TargetSource targetSource) {

        System.out.println("========AspectDs.com.jack.controller.xx");
        String value = targetSource.value();

        if(value != null && !"".equals(value)) {
            DynamicDataSourceHolder.getLocal().set(value);
        } else {
            DynamicDataSourceHolder.getLocal().set("ds1");
        }
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            DynamicDataSourceHolder.getLocal().remove();
        }

        return null;
    }
}
