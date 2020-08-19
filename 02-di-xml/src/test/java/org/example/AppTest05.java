package org.example;

import org.example.ba05.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest05
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
     * 引用类型的自动注入ByType 同源第一种
     *
     */

    @Test
    public void test01(){

        //定义配置文件
        String config = "ba05/applicationContext.xml";

        //容器生成对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从容器中获取对象
        Student student =(Student) alc.getBean("myStudent");

        //输出student
        System.out.println("Student "+student);


    }


    /**
     * 引用类型的自动注入ByType 同源第二种，父子类
     *
     */

    @Test
    public void test02(){

        //定义配置文件
        String config = "ba05/applicationContext.xml";

        //容器生成对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从容器中获取对象
        Student student =(Student) alc.getBean("myStudent");

        //输出student
        System.out.println("Student "+student);


    }









}
