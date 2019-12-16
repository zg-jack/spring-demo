package com.xiangxue.jack.designPattern.decorator;

public class Decorator2016 extends Decorator {

    public Decorator2016(House house) {
        super(house);
    }

    public void findWife() {
        JackHouse2001 jackHouse2001 = (JackHouse2001)house;
        jackHouse2001.getPeoples().add("老婆");
        System.out.println("=========2016Jack找到老婆结婚了===========");
    }

    @Override
    public void people() {
        //2001年的人都还在，Jack，老爸，老妈
        super.people();

        findWife();
    }

    public void addGoods() {
        JackHouse2001 jackHouse2001 = (JackHouse2001)house;
        jackHouse2001.getGoods().add("电视机");
        jackHouse2001.getGoods().add("电冰箱");
        System.out.println("========2016买了电视机、电冰箱============");
    }

    @Override
    public void goods() {
        //2001年的手电筒还在
        super.goods();

        addGoods();
    }
}
