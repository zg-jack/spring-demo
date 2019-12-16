package com.xiangxue.jack.designPattern.decorator;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/*
* JackHouse2001是被装饰对象，后续装饰者对该对象进行修改装饰
* */
@Data
public class JackHouse2001 implements House{

    private List<String> peoples = new ArrayList<>();

    private List<String> goods = new ArrayList<>();

    @Override
    public void people() {
        peoples.add("老爸");
        peoples.add("老妈");
        peoples.add("Jack");
        System.out.println("=======2001年Jack家里只有老爸，老妈和Jack=========");
    }

    @Override
    public void goods() {
        goods.add("手电筒");
        System.out.println("=======2001年Jack家里只有一个手电筒=========");
    }
}
