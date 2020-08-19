package org.example;

import static org.junit.Assert.assertTrue;


import org.example.ba02.School;
import org.example.ba02.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test     //单元测试 依赖中的junit
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    /**
     * 测试方法，使用junit
     * 1、定义方法，public void 自定义方法名() {}
     * 2、在方法上面加入@Test注解
     * 3、把光标放在方法上面，执行run test
     */


    /**
     * 测试设值注入的简单类型
     */

    @Test
    public void test01(){

        //定义配置文件
        String config = "ba01/applicationContext.xml";

        //容器生成对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从容器中获取对象
        Student student =(Student) alc.getBean("myStudent");

        //输出student
        System.out.println("Student "+student);


    }


    /**
     * 测试设值注入的引用类型:ref作为属性
     */
    @Test
    public void test02(){

        //设置配置文件
        String config = "ba02/applicationContext.xml";

        //容器生成对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从容器中获取对象
        Student student = (Student) alc.getBean("myStudent");

        //输出
        System.out.println("Student "+student);

        //不用Spring
        /*Student student1 = new Student();
        student1.setName("李四");
        student1.setAge(21);

        School school = new School();
        school.setName("xust");
        school.setAddress("xian");
        student1.setSchool(school);*/

    }


    /**
     * 测试设值注入的引用类型：ref作为字标签
     */
    @Test
    public void test03(){

        //定义配置文件
        String config = "ba02/applicationContext.xml";

        //生成容器对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从容器中获取对象
        Student student = (Student) alc.getBean("myStudent01");

        //输出
        System.out.println("Student "+student);


    }





}
