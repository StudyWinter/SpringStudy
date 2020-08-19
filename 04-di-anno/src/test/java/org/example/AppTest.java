package org.example;

import static org.junit.Assert.assertTrue;

import org.example.ba01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{


    /**
     * Component注解，有value值的，value也可以省略
     */
    @Test
    public void test01(){

        //定义配置文件
        String config = "applicationContext.xml";

        //创建容器对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //获取对象
        Student student= (Student) alc.getBean("myStudent");

        //输出对象
        System.out.println(student);


    }

}
