package com.xiangxue.jack.spi;

public class SpiService1Impl implements SpiService {
    @Override
    public String query(String param) {
        System.out.println("=======SpiServiceImpl.query1======");
        return "OK";
    }
}
