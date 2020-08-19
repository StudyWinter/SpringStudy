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
     * 测试环绕通知
     */
    @Test
    public void test01(){
        //定义配置文件
        String config = "applicationContext.xml";

        //生成容器
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从容器中获取对象
        someService proxy = (someService) alc.getBean("proxyObject");

        //proxy com.sun.proxy.$Proxy4
        System.out.println("proxy "+proxy.getClass().getName());

        //执行
        proxy.doSome();

    }


}
