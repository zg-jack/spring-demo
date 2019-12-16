package com.xiangxue.jack.designPattern.decorator;

public class Test {
    public static void main(String[] args) {
        House house = new JackHouse2001();
        System.out.println("=======2001情况=========");
        house.people();
        house.goods();
        System.out.println("=======2001情况=========\n");

        System.out.println("=======2016情况=========");
        House house1 = new Decorator2016(house);
        house1.people();
        house1.goods();
        System.out.println("=======2016情况=========\n");

        System.out.println("=======2017情况=========");
        House house2 = new Decorator2017(house);
        house2.people();
        house2.goods();
        System.out.println("=======2017情况=========\n");
    }
}
