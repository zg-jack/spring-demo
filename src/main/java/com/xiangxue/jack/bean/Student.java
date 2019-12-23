package com.xiangxue.jack.bean;

import lombok.Data;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Service;

//@Lazy
@Data
@Service
@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
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
