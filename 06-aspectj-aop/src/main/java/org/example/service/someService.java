package org.example.service;

import org.example.beans.Student;

/**
 * 接口
 */
public interface someService {

    //业务方法
    void doSome(String name,int age);


    //测试后置通知 @AfterReturing
    String doOther(String name,int age);

    //测试返回值是一个自定义类型
    Student doOther2(String name,int age);

    //测试环绕通知
    String doFirst(String name,int age);

    //测试异常通知
    void doSecond(String name,int age);

    //最终通知
    void doThird();

}
