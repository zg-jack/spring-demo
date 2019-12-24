package com.xiangxue.jack.aop;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

/*
* @Service会被@ComponentScan扫描到
* */
@Service
/*
* 开启注解AOP
* 替代了：<aop:aspectj-autoproxy/>
* */
@EnableAspectJAutoProxy
public class EnableAspectJAutoProxyBean {
}
