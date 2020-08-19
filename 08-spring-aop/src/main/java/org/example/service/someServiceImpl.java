package org.example.service;

public class someServiceImpl implements someService {

    //测试环绕通知
    @Override
    public void doSome() {
        System.out.println("===执行方法是doSome===");
    }


}
