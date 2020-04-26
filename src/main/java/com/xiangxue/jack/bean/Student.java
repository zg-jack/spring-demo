package com.xiangxue.jack.bean;

import lombok.Data;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

//@Lazy
@Data
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,proxyMode = ScopedProxyMode.INTERFACES)
public class Student {
    private String username = "Jack";

    private String password;

/*    private ConstructorAutowiredBean constructorAutowiredBean;

    @Autowired
    public Student(ConstructorAutowiredBean constructorAutowiredBean) {
        this.constructorAutowiredBean = constructorAutowiredBean;
    }*/

/*    public Student(String username) {
        this.username = username;
    }*/
}
