package org.example;

import static org.junit.Assert.assertTrue;


import org.example.beans.Student;
import org.example.service.orderServiceImpl;
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
     * Before注解测试，目标类无参数
     */
   /* @Test
    public void test01(){
        //定义配置文件
        String config = "applicationContext.xml";

        //创建容器对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从spring容器中获取目标对象(代理对象)
        someService proxy = (someService) alc.getBean("someServiceTarget");

        //输出代理  proxy: com.sun.proxy.$Proxy6：目标类有接口，框架默认使用jdk动态代理
        System.out.println("proxy: "+proxy.getClass().getName());

        //通过代理执行业务方法，实现功能的增强
        proxy.doSome();
    }*/
    /**
     * Before注解测试，目标类有参数
     */

    @Test
    public void test02(){
        //定义配置文件
        String config = "applicationContext.xml";

        //创建容器对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从spring容器中获取目标对象(代理对象)
        someService proxy = (someService) alc.getBean("someServiceTarget");

        //输出代理  proxy: com.sun.proxy.$Proxy6：目标类有接口，框架默认使用jdk动态代理
        System.out.println("proxy: "+proxy.getClass().getName());

        //通过代理执行业务方法，实现功能的增强
        proxy.doSome("lisi",20);    //此时无法输出日志
    }


    /**
     * 后置测试
     */
    @Test
    public void test03(){
        //定义配置文件
        String config = "applicationContext.xml";

        //创建容器对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从spring容器中获取目标对象(代理对象)
        someService proxy = (someService) alc.getBean("someServiceTarget");

        //输出代理  proxy: com.sun.proxy.$Proxy6：目标类有接口，框架默认使用jdk动态代理
       // System.out.println("proxy: "+proxy.getClass().getName());

        //通过代理执行业务方法，实现功能的增强
        String s = proxy.doOther("zhangsan", 22);
        System.out.println("s "+s);
    }



    /**
     * 后置测试22 返回值是一个自定义类型
     */
    @Test
    public void test04(){
        //定义配置文件
        String config = "applicationContext.xml";

        //创建容器对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从spring容器中获取目标对象(代理对象)
        someService proxy = (someService) alc.getBean("someServiceTarget");

        //输出代理  proxy: com.sun.proxy.$Proxy6：目标类有接口，框架默认使用jdk动态代理
        // System.out.println("proxy: "+proxy.getClass().getName());

        //通过代理执行业务方法，实现功能的增强
        Student stu = proxy.doOther2("zhangsan", 22);
        System.out.println("stu: "+stu);
    }

    /**
     * 测试环绕通知
     */
    @Test
    public void test05(){
        //定义配置文件
        String config = "applicationContext.xml";

        //创建容器对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从spring容器中获取目标对象(代理对象)
        someService proxy = (someService) alc.getBean("someServiceTarget");

        String str = proxy.doFirst("zs",24);    //相当于调用myAround

        System.out.println("str "+str);
    }


    /**
     * 4、异常通知
     */
    @Test
    public void test06(){
        //定义配置文件
        String config = "applicationContext.xml";

        //创建容器对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从spring容器中获取目标对象(代理对象)
        someService proxy = (someService) alc.getBean("someServiceTarget");

        proxy.doSecond("lisi",24);
    }

    /**
     * 4、最终通知
     */
    @Test
    public void test07(){
        //定义配置文件
        String config = "applicationContext.xml";

        //创建容器对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从spring容器中获取目标对象(代理对象)
        someService proxy = (someService) alc.getBean("someServiceTarget");

       proxy.doThird();
    }


/**
 * Before注解测试，无接口的
 */
    @Test
    public void test08(){
        //定义配置文件
        String config = "applicationContext.xml";

        //创建容器对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从spring容器中获取目标对象(代理对象)
        orderServiceImpl proxy= (orderServiceImpl) alc.getBean("orderServiceTarget");

        //输出代理 proxy: org.example.service.orderServiceImpl$$EnhancerBySpringCGLIB$$e85fc44
        //目标类没有接口，使用的的是cglib动态代理
        System.out.println("proxy: "+proxy.getClass().getName());

        proxy.createOrder();
    }
}
