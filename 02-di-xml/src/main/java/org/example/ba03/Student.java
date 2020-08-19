package org.example.ba03;

public class Student {

    //属性
    private String name;
    private int age;

    //引用类型
    private School school;

    //有参数的构造方法
    public Student(String myName, int myAge, School mySchool) {
        System.out.println("Student 的有参数的构造方法");
        this.name = myName;
        this.age = myAge;
        this.school = mySchool;
    }

    //无参构造方法
    public Student() {
        System.out.println("Student's Constructor");
    }

    //set方法
    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public void setAge(int age) {

        this.age = age;
    }

    public void setSchool(School school) {
        System.out.println("setSchool:"+school);
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
