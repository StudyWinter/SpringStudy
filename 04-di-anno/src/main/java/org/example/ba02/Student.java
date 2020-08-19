package org.example.ba02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("myStudent")
public class Student {
    /**
     * @Value:简单类型的属性赋值
     *      属性：value 是String类型的，表示简单类型的属性值
     *      位置：
     *          1、在属性定义的上面，无需set方法，常用的方式
     *          2、在set方法的上面，用的少
     */
    //@Value(value ="张三")
    @Value("李四")      //可以省略value
    private String name;

   // @Value(value ="23")
    //@Value("24")
    private int age;

    //setter方法
    public void setName(String name) {
        this.name = name;
    }


    //在set方法的上面，用的少
    @Value("24")
    public void setAge(int age) {
        System.out.println("setAge "+age);
        this.age = age;
    }


    //toString方法
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
