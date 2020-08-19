package org.example;

import org.example.ba06.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest06
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
     * 为应用程序指定多个Spring配置文件
     *
     */

    @Test
    public void test01(){

        //定义配置文件
        String config = "ba06/total.xml";

        //容器生成对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从容器中获取对象
        Student student =(Student) alc.getBean("myStudent");

        //输出student
        System.out.println("Student "+student);


    }





}
