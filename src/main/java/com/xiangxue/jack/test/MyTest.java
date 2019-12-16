package com.xiangxue.jack.test;

import com.xiangxue.jack.bean.*;
import com.xiangxue.jack.beanDefinition.BeanClass;
import com.xiangxue.jack.factoryBean.FactoryB;
import com.xiangxue.jack.factoryBean.FactoryBeanDemo;
import com.xiangxue.jack.service.UserService;
import com.xiangxue.jack.targetSource.Girl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.lang.reflect.Method;
import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml"})
public class MyTest {

    @Autowired
    private ApplicationContext applicationContext;

//    @Autowired
//    private AccountService accountService;

    @Autowired
    private UserService userService;

    @Autowired
    private PropertyClass propertyClass;

    @Autowired
    private ShowSixClass showSixClass;

    @Autowired
    private OriginClass originClass;

    @Autowired
    private ConstructorArgBean constructorArgBean;

    @Test
    public void test1() {
        applicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        ((ClassPathXmlApplicationContext) applicationContext).setAllowBeanDefinitionOverriding(false);
//        ((ClassPathXmlApplicationContext) applicationContext).setAllowCircularReferences(true);
//        ((ClassPathXmlApplicationContext) applicationContext).refresh();
//        AccountService bean = applicationContext.getBean(AccountService.class);
        System.out.println("");

        applicationContext.getBean(Student.class);
    }

    @Test
    public void test2() {
        applicationContext = new FileSystemXmlApplicationContext("E:\\idea\\xiangxueedu-vip-2\\spring-source\\src\\main\\resources\\spring.xml");
    }

    @Test
    public void test3() {
        applicationContext = new AnnotationConfigApplicationContext("com.xiangxue.jack");
        BeanClass beanClass = (BeanClass)applicationContext.getBean("beanClass");
        System.out.println("BeanClass-->" + beanClass.getUsername());
    }

    @Test
    public void test4() {
        applicationContext = new AnnotationConfigApplicationContext("com.xiangxue.jack");
        FactoryB factoryB = (FactoryB)applicationContext.getBean("factoryBeanDemo");
        System.out.println(factoryB);

        FactoryBeanDemo factoryBeanDemo = (FactoryBeanDemo)applicationContext.getBean("&factoryBeanDemo");
        System.out.println(factoryBeanDemo);
    }

    @Test
    public void lookUpMethod() {
        showSixClass.showsix();
    }

    @Test
    public void replacedMethod() {
        originClass.method("xx");
        originClass.method(new ArrayList());
    }

    @Test
    public void constructorArg() {
        System.out.println(constructorArgBean);
    }

    @Autowired
    Jedis jedis;

    @Test
    public void constomTag() {
        jedis.set("name9090","jack---9090");

        System.out.println(jedis.get("name9090"));
    }

    @Test
    public void targetSourceCreatorTest() {
        Girl girl = (Girl) applicationContext.getBean("girl");
        System.out.println(girl.getUsername());
    }

    @Autowired
    ConstructorAutowiredBean constructorAutowiredBean;

    @Test
    public void constructorAutowiredTest() {
        System.out.println(constructorAutowiredBean.getStudent().getUsername());
    }

    @Autowired
    MyAnnoClass myAnnoClass;

    @Test
    public void CostomAnno() {
        System.out.println("CostomAnno--->" + myAnnoClass.getUsername());
    }

    public static void main(String[] args) {
        LocalVariableTableParameterNameDiscoverer lv = new LocalVariableTableParameterNameDiscoverer();
        Method[] declaredMethods = MyTest.class.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            String[] names = lv.getParameterNames(declaredMethod);

            for (String name : names) {
                System.out.println(name);
            }
        }
    }
}
