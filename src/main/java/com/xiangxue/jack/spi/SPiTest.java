package com.xiangxue.jack.spi;

import java.util.ServiceLoader;

public class SPiTest {
    public static void main(String[] args) {

        /*
        * 粒度不够细
        *
        * 通过配置的方式要唯一确定一个类
        * */
        ServiceLoader<SpiService> load = ServiceLoader.load(SpiService.class);

        for (SpiService spiService : load) {
            spiService.query("90");
        }
    }
}
