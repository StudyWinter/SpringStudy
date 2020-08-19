package org.example.ba03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("myStudent")
public class Student {
    /**
     * @Autowired:引用类型的赋值
     *
     */

    //@Value(value ="张三")
    @Value("李四")      //可以省略value
    private String name;

   // @Value(value ="23")
    //@Value("24")
    private int age;

    /**
     * 引用类型的School
     * @AutoWired:引用类型的自动注入，支持ByName,ByType。默认是ByType
     * 位置：
     *      1、属性定义的上面，无需set方法，常用的方式
     *      2、在set方法的上面
     */
    //ByType的方式
    @Autowired
    private School school;

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

    public void setSchool(School school) {
        this.school = school;
    }

    //toString方法
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
