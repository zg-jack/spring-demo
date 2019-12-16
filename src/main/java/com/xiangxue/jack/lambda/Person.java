package com.xiangxue.jack.lambda;

/*
* 其实之前在讲Lambda表达式的时候提到过，所谓的函数式接口，当然首先是一个接口，
* 然后就是在这个接口里面只能有一个抽象方法。
  这种类型的接口也称为SAM接口，即Single Abstract Method interfaces。
* */
@FunctionalInterface
public interface Person {

    int eat(String x);


    /*
    * 函数式接口里允许定义默认方法
    * */
    default void sleep() {
        System.out.println("===睡觉====");
    }

    /*
    * 函数式接口里允许定义java.lang.Object里的public方法
    * */
    boolean equals(Object o);

    /*
    * 函数式接口里允许定义静态方法
    * */
    static void love() {
        System.out.println("==爱==");
    }
}
