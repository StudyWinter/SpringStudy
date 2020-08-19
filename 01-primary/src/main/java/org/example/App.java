package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Spring!" );

        //定义Spring的配置文件，配置文件是在类路径的根目录下
        String config = "applicationContext.xml";

        //创建Spring容器对象，根据Spring配置文件的位置，使用接口的不同实现类
        //如果Spring的配置文件是在类路径（classpath）,使用的是ClassPathXmlApplicationContext
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从容器中获取对象，使用的是getBean
        SomeService someService = (SomeService) alc.getBean("someService");

        //调用业务方法
        someService.doSome();

    }
}
