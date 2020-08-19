package org.example.ba04;

public class Student {

    //属性
    private String name;
    private int age;

    //引用类型
    private School school;



    //无参构造方法
    public Student() {
        System.out.println("Student's Constructor");
    }

    //set方法
    public void setName(String name) {
        this.name = name;
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
