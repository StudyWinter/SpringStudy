package org.example.service;

import org.example.beans.Student;

/**
 * 在doSome方法之前打印日志
 */

public class someServiceImpl implements someService {

    @Override
    public void doSome(String name,int age) {
        System.out.println("someServiceImpl的业务方法doSome");
    }

    //测试后置通知 @AfterReturing
    @Override
    public String doOther(String name, int age) {
        System.out.println("someServiceImpl的业务方法doOther");
        return "xust";
    }

    @Override
    public Student doOther2(String name, int age) {
        System.out.println("someServiceImpl的业务方法doOther2");

        Student student = new Student();
        student.setName("wangwu");
        student.setAge(21);
        return student;
    }

    //测试环绕通知
    @Override
    public String doFirst(String name, int age) {
        System.out.println("someServiceImpl的业务方法doFirst");

        return "doFirst";
    }

    //测试异常通知,这个方法中没有异常，测试时就执行这个方法，接下来产生异常
    @Override
    public void doSecond(String name, int age) {
        System.out.println("someServiceImpl的业务方法doSecond");
        int i = 10 / 0;              //产生异常

    }

    //测试最终通知
    @Override
    public void doThird() {
        System.out.println("someServiceImpl的业务方法doThird");
        int i = 10 / 0;              //产生异常
    }


}
