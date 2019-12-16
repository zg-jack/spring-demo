package com.xiangxue.jack.lambda;


/*
*
* Lambda表达式，不要关心接口是什么，接口里面方法是什么，你只要关心方法里面写什么代码就可以了
*
* 方法引用：不要关心接口是什么，接口里面方法是什么，，只要关心如何调用方法就可以了
* */
public class LambdaDemo {

    public static void main(String[] args) {
        Person person = x -> 1;

        //等价于

        Person person1 = new Person() {
            @Override
            public int eat(String x) {
                return 1;
            }
        };

        System.out.println(person.eat(""));
        System.out.println(person.equals(1));
        person.sleep();


        Person person2 = new LambdaDemo()::doSomething;

        //等价于

        Person person3 = x -> new LambdaDemo().doSomething("");

        //等价于

        Person person4 = new Person() {
            @Override
            public int eat(String x) {
                return new LambdaDemo().doSomething("");
            }
        };

        System.out.println(person2.eat(""));

        System.out.println(person3.eat(""));
    }

    public int doSomething(String x) {
        System.out.println("======我要做事");
        System.out.println("]]]]]==");
        return 9;
    }
}
