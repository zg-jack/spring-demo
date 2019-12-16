package com.xiangxue.jack.bean;

//@Scope(scopeName = "jack",proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Woman implements People {
    @Override
    public void showsix() {
        System.out.println("i am woman");
    }
}
