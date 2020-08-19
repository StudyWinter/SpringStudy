package org.example;

import static org.junit.Assert.assertTrue;


import org.example.service.someService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * 测试前置通知
     */
    @Test
    public void test01(){
        //定义配置文件
        String config = "applicationContext.xml";

        //生成容器
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从容器中获取对象
        someService proxy = (someService) alc.getBean("someService");

        //proxy代理: com.sun.proxy.$Proxy4
        System.out.println("proxy代理: "+proxy.getClass().getName());

        //通过代理执行业务方法，实现功能的增强
        proxy.doSome();

    }


    /**
     * 测试后置通知
     */
    @Test
    public void test02(){
        //定义配置文件
        String config = "applicationContext2.xml";

        //生成容器
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从容器中获取对象
        someService proxy = (someService) alc.getBean("someService");

        //proxy代理: com.sun.proxy.$Proxy4
        System.out.println("proxy代理: "+proxy.getClass().getName());

        //通过代理执行业务方法，实现功能的增强
        proxy.doSome2();

    }
}
