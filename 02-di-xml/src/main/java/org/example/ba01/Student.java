package org.example.ba01;

public class Student {

    //属性
    private String name;
    private int age;

    //set方法

    /**
     * 没有set方法报错
     * Bean property 'name' is not writable or has an invalid setter method.
     *
     */


    public void setName(String name) {
        System.out.println("setName "+name);
        this.name = name.toUpperCase();
    }

    public void setAge(int age) {
        System.out.println("setAge "+age);
        this.age = age;
    }

    //有属性sex
    public void setSex(String sex){
        System.out.println("setSex "+sex);
    }

    //无参构造
    public Student() {
        System.out.println("Student‘s constructor");
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
