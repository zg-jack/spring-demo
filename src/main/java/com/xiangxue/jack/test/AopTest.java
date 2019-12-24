package com.xiangxue.jack.test;


import com.xiangxue.jack.bean.ComponentScanBean;
import com.xiangxue.jack.costomAdvice.BeforeAdviceBean;
import com.xiangxue.jack.service.DataCheck;
import com.xiangxue.jack.service.UserService;
import com.xiangxue.jack.service.UserServiceImpl;
import com.xiangxue.jack.service1.BankService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
        System.out.println(userService.queryUser("jack"));
    }

    @Test
    public void test2() {
        BankService bankService = applicationContext.getBean(BankService.class);
        System.out.println(bankService.queryBank("jack"));
    }

    @Test
    public void introductionTest() {
        BankService bean = applicationContext.getBean(BankService.class);
        System.out.println(bean.queryBank("jack"));

        DataCheck dataCheck = (DataCheck)bean;
        dataCheck.check();
    }

    @Test
    public void proxyFactoryTest() {
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(new UserServiceImpl());
        pf.addAdvice(new BeforeAdviceBean());

        UserServiceImpl proxy = (UserServiceImpl)pf.getProxy();
        System.out.println(proxy.queryUser("jack"));
    }

    @Test
    public void annoIntercepoter() {
        BankService bean = applicationContext.getBean(BankService.class);
        bean.queryArea("jack");
        bean.returnValue("jack");
        bean.ThrowMethod("jack");
    }
}
