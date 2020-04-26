package com.xiangxue.jack.test;


import com.xiangxue.jack.aop.cglib.UserServiceImpl;
import com.xiangxue.jack.bean.ComponentScanBean;
import com.xiangxue.jack.costomAdvice.BeforeAdviceBean;
import com.xiangxue.jack.service.AccountService;
import com.xiangxue.jack.service.DataCheck;
import com.xiangxue.jack.service.UserService;
import com.xiangxue.jack.service1.BankService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

public class AopTest {

    @Autowired
    UserService userService;

    private ApplicationContext applicationContext;

    @Before
    public void before() {
        applicationContext = new AnnotationConfigApplicationContext(ComponentScanBean.class);
    }

    @Test
    public void test1() {
        UserService userService = applicationContext.getBean(UserService.class);
//        userService.queryUser("jack");

        userService.addxx("1");
    }

    @Test
    public void circularRef() {
        UserService userService = applicationContext.getBean(UserService.class);
        AccountService accountService = applicationContext.getBean(AccountService.class);
        userService.queryUser("1");
        accountService.queryAccount("2");
    }

    @Test
    public void test2() {
        BankService bankService = applicationContext.getBean(BankService.class);
        System.out.println(bankService.returnValue("1"));
    }

    @Test
    public void introductionTest() {
        BankService bean = applicationContext.getBean(BankService.class);
        System.out.println(bean.queryBank("jack",1,new ArrayList()));

        DataCheck dataCheck = (DataCheck)bean;
        dataCheck.check();
    }

    /*
    * 可以做一波甜点，带着找问题
    * */
    @Test
    public void costomInterceptorTest() {

        AnnotationAwareAspectJAutoProxyCreator bean = applicationContext.getBean(AnnotationAwareAspectJAutoProxyCreator.class);
        bean.setInterceptorNames("girlMethodInterceptor");

        UserService userService = applicationContext.getBean(UserService.class);
        userService.queryUser("a");
    }

    @Test
    public void proxyFactoryTest() {
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(new UserServiceImpl());
        pf.addAdvice(new BeforeAdviceBean());

        UserServiceImpl proxy = (UserServiceImpl)pf.getProxy();
    }

    @Test
    public void annoIntercepoter() {
        BankService bean = applicationContext.getBean(BankService.class);
        bean.queryArea("jack");
        bean.returnValue("jack");
        bean.ThrowMethod("jack");
    }
}
