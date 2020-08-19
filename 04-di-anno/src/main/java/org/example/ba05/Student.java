package org.example.ba05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


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
     * @Resource :来自jdk,可以给引用类型赋值，Spring框架支持这个注解的使用
     *              默认是byName子自动注入
     *
     *              位置  1、在属性定义的上面，无需set方法，推荐使用
     *                   2、在set方法的上面
     */
    //默认是byName。先使用ByName赋值，如果ByName赋值失败，则再使用ByType
    @Resource
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
