package com.xiangxue.jack.targetSource;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

//@Service
public class GirlMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        System.out.println("专门拦路拦截漂亮妹妹！！");
        return null;
    }
}
