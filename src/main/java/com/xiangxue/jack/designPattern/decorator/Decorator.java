package com.xiangxue.jack.designPattern.decorator;

/*
* 装饰者类，是对房子的装饰，所以需要实现house接口
*
* 装饰者规定了装饰流程，就是规定了接口调用过程，具体子类实例方法如何调用
* 子类去实现
* */
public abstract class Decorator implements House {

    public House house;

    public Decorator(House house) {
        this.house = house;
    }

    @Override
    public void people() {
        house.people();
    }

    @Override
    public void goods() {
        house.goods();
    }
}
