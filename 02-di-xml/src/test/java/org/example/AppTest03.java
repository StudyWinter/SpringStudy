package org.example;

import org.example.ba03.Student;
import org.example.ba03.School;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest03
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
     * 测试构造注入name属性
     */

    @Test
    public void test01(){

        //定义配置文件
        String config = "ba03/applicationContext.xml";

        //容器生成对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从容器中获取对象
        Student student =(Student) alc.getBean("myStudent");

        //输出student
        System.out.println("Student "+student);


    }


    /**
     * 测试构造注入index属性
     */

    @Test
    public void test02(){

        //定义配置文件
        String config = "ba03/applicationContext.xml";

        //容器生成对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从容器中获取对象
        Student student =(Student) alc.getBean("myStudent2");

        //输出student
        System.out.println("Student "+student);


    }



    /**
     * 测试构造注入index属性,省略index
     */

    @Test
    public void test03(){

        //定义配置文件
        String config = "ba03/applicationContext.xml";

        //容器生成对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从容器中获取对象
        Student student =(Student) alc.getBean("myStudent3");

        //输出student
        System.out.println("Student "+student);


    }


    /**
     * 测试非自定义的对象
     */
    @Test
    public void test04(){
        //定义配置文件
        String config = "ba03/applicationContext.xml";

        //容器中生成对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //获得对象
        Date date= (Date) alc.getBean("mtDate");

        //输出
        System.out.println("Date "+date);


    }



}
