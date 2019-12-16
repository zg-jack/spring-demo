package com.xiangxue.jack.targetSource;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.aop.config.AopConfigUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
public class TargetSourceCreatorBean {

    @Autowired
    private BeanFactory beanFactory;

    /*
    * TODO beanDefinition中的factoryMethod属性实现的
    * */
    @Bean(AopConfigUtils.AUTO_PROXY_CREATOR_BEAN_NAME)
    public AnnotationAwareAspectJAutoProxyCreator annotationAwareAspectJAutoProxyCreator() {
        AnnotationAwareAspectJAutoProxyCreator creator = new AnnotationAwareAspectJAutoProxyCreator();
        // creator.setProxyTargetClass(true); 建议这里不要设置，还是取用注解的值来灵活控制最好了
        MyTargetSourceCreator myTargetSourceCreator = new MyTargetSourceCreator();
        myTargetSourceCreator.setBeanFactory(beanFactory);
        creator.setCustomTargetSourceCreators(myTargetSourceCreator);

        creator.setInterceptorNames("girlMethodInterceptor");
        return creator;
    }
}
