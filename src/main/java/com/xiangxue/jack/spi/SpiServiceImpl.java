package com.xiangxue.jack.spi;

public class SpiServiceImpl implements SpiService {
    @Override
    public String query(String param) {
        System.out.println("=======SpiServiceImpl.query======");
        return "OK";
    }
}
