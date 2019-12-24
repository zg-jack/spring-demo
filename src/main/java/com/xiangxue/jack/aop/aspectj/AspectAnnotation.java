package com.xiangxue.jack.aop.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectAnnotation {


    /*
    * introduction 引介动态添加功能，并且改变目标类的类型，其实就是目标类多实现了接口而已
    * */
/*    @DeclareParents(value = "com.xiangxue.jack.service1.BankServiceImpl",
            defaultImpl = com.xiangxue.jack.service.DataCheckImpl.class)
    private DataCheck dataCheck;*/

    @Pointcut("execution(public * com.xiangxue.jack.service.*.*(..))")
    public void pc1(){}

    @Around("pc1()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("==============AspectAnnotation around前置通知=========");
        Object result = joinPoint.proceed();
        System.out.println("==============AspectAnnotation around后置通知=========");

        return result;
    }


/*    @Before(value = "@annotation(targetMethod)"*//*,argNames = "joinPoint,targetMethod"*//*)
    public void xx(JoinPoint joinPoint, TargetMethod targetMethod) {
        System.out.println("===============注解拦截 前置通知=========");
        System.out.println("==================targetMethod.name = " + targetMethod.name());
    }

    @AfterReturning(value = "@annotation(returnValue)",returning = "retVal")
    public void afterReturning(JoinPoint joinPoint, ReturnValue returnValue, Object retVal) {
        System.out.println("==============AspectAnnotation 后置通知  拿返回值=========" + retVal);
    }

    @AfterThrowing(value = "@annotation(throwsAnno)",throwing = "e")
    public void throwMethod(JoinPoint joinPoint, ThrowsAnno throwsAnno, Throwable e) {
        System.out.println("==============AspectAnnotation 异常通知  拿异常=========" + e);
    }*/
}
