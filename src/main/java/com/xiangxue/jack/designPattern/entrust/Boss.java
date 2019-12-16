package com.xiangxue.jack.designPattern.entrust;

public class Boss implements Company {

    Sun sun = new Sun();

    /*
    * 老板直接委托sun公司去生产
    * */
    @Override
    public void product() {
        sun.product();
    }
}
