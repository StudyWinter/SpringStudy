package org.example;

import org.example.ba05.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest05
{


    /**
     * @Value注解
     */
    @Test
    public void test01(){

        //定义配置文件
        String config = "ba05/applicationContext.xml";

        //创建容器对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //获取对象
        Student student= (Student) alc.getBean("myStudent");

        //输出对象
        System.out.println(student);


    }

}
