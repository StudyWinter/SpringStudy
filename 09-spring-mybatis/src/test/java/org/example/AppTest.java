package org.example;

import static org.junit.Assert.assertTrue;

import org.example.beans.Student;
import org.example.service.StudentService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * 测试添加学生
     */

    @Test
    public void addStudent(){

        //定义配置文件
        String config = "applicationContext.xml";

        //创建容器
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从容器中获取对象
        StudentService service = (StudentService) alc.getBean("studentService");

        //定义Student对象
        Student student = new Student();
        student.setName("李四");
        student.setAge(20);

        //调用方法
        int i = service.addStudent(student);

        //输出
        System.out.println("addStudent nums "+i);

    }


    /**
     * 测试查询
     */
    @Test
    public void queryStudent(){
        //定义配置文件
        String config = "applicationContext.xml";

        //创建容器
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从容器中获取对象
        StudentService service = (StudentService) alc.getBean("studentService");

        //查询
        List<Student> students = service.queryStudents();

        //输出
        for (Student student : students) {
            System.out.println(student);
        }

    }

}
