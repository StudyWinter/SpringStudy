package org.example.service;

public class someServiceImpl implements someService {

    //测试前置通知，打印日志
    @Override
    public void doSome() {
        System.out.println("===执行方法是doSome===");
    }

    //测试后置通知，打印日志
    @Override
    public void doSome2() {
        System.out.println("===执行方法是doSome2===");
    }
}
