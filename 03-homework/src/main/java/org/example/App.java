package org.example;

import org.example.beans.User;
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

        //创建容器对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从容器中获取对象
        UserServiceImpl userService = (UserServiceImpl) alc.getBean("myUserService");
        User user= (User) alc.getBean("myUser");


        //调用业务
        userService.addUser(user);


    }
}
