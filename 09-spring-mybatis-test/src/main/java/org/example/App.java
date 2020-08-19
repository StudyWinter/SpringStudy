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
        System.out.println( "Hello World!" );

        //定义配置文件
        String config = "applicationContext.xml";

        //容器
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从容器中获取对象
        String names[] = alc.getBeanDefinitionNames();
        for (String name : names) {

            //输出
            System.out.println(name);
        }


    }
}
