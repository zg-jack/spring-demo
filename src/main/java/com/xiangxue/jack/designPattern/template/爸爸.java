package com.xiangxue.jack.designPattern.template;

public abstract class 爸爸 {

    public void 生活() {
        学习();
        工作();
        爱情();
    }

    public void 学习() {
        System.out.println("====要认认真真学习====");
    }

    public void 工作() {
        System.out.println("====主动承担责任====");
    }
    /*
    * 该方法就是一个钩子方法，通过子类的实现干预父类的方法的业务流程
    * 钩子方法挂载到父类方法中执行
    * */
    //这里爸爸不强迫孩子的爱情，孩子自己实现自己的爱情
    public abstract void 爱情();
}
