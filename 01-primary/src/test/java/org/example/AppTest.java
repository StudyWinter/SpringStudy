package org.example;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

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

    @Test
    public void test01(){

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

    /**
     * 测试容器的其他使用方式，把Spring的配置文件放在项目的根目录之下
     * 和src\target时同级的目录位置，
     *
     * 使用FileSystemXmlApplicationContext读取配置文件
     */

    @Test
    public void test02(){

        System.out.println("Hello Spring");

        //定义配置文件,放在项目的根之下，这里只给出文件名称
        String config = "spring.xml";
        ApplicationContext alc = new FileSystemXmlApplicationContext(config);

        SomeService someService = (SomeService) alc.getBean("someService01");
        someService.doSome();
    }

    /**
     * 容器中对称的创建时间？
     * 默认在创建容器对象时，把配置文件中的所用对象都创建出来，放到容器中
     *
     * 优点;
     * 获取文件快、对象已经已经创建好了，拿来就用
     *
     *
     * 缺点：占内存
     */

    @Test
     public void test03(){

        //定义Spring的配置文件，配置文件是在类路径的根目录下
        String config = "applicationContext.xml";

        //创建Spring容器对象，根据Spring配置文件的位置，使用接口的不同实现类
        //如果Spring的配置文件是在类路径（classpath）,使用的是ClassPathXmlApplicationContext
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

      /*  //从容器中获取对象，使用的是getBean
        SomeService someService = (SomeService) alc.getBean("someService");

        //调用业务方法
        someService.doSome();*/
     }


    /**
     * 获取容器中对象的信息
     */
    @Test
    public void test04(){

        //定义Spring的配置文件，配置文件是在类路径的根目录下
        String config = "applicationContext.xml";

        //创建容器
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //获取容器中定义的对象数量
        int nums = alc.getBeanDefinitionCount();

        //输出
        System.out.println("容器中对象的数量 " + nums);    //2个对象

        //获取容器中每个对象的名称
        String[] names = alc.getBeanDefinitionNames();

        //输出
        for (String name : names) {
            System.out.println(name);  //someService 和 someService1  其实就是配置文件中的id

        }
    }


    /**
     *  Spring默认是调用类的无参数构造方法来创建对象
     */
    @Test
    public void test05(){

        //定义配置文件
        String config = "applicationContext.xml";

        //创建容器
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从容器中获取对象,这个不是抽取的赋值
        SomeService someService =(SomeService) alc.getBean("someService");

        //执行业务方法
        someService.doSome();

    }


    /**
     * 单例测试，默认的
     * 单例对象是在什么时候创建的？
     *      也是在创建容器对象时，会创建所有单例对象
     *  优点：速度快、方便
     */
    @Test
    public void test06(){

        //定义配置文件
        String config = "applicationContext.xml";

        //创建容器
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从容器中获取对象,因为是单例，所有每次获取都是同一个对象，即someService1和someService2是相同的
        SomeService someService1 =(SomeService) alc.getBean("service1");
        SomeService someService2 =(SomeService) alc.getBean("service1");

        if(someService1 == someService2)
        {
            System.out.println("someService1 和 someService2    是同一个对象");
        }
        else
        {
            System.out.println("someService1 和 someService2   不是同一个对象");
        }
    }


    /**
     * 原型测试
     * 原型对象创建的时间？
     *      把创建对象的时间延迟了，延迟到使用对象的时候，
     *      在执行getBean()的时候创建对象。
     *
     * 优点：不占内存
     * 缺点：获取对象速度慢
     *
     */
    @Test
    public void test07(){

        //创建配置文件
        String config = "applicationContext.xml";

        //创建个容器
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //从容器中获取对象
        SomeService someService1 = (SomeService) alc.getBean("service2");
        SomeService someService2 = (SomeService) alc.getBean("service2");

        System.out.println(someService1.hashCode());
        System.out.println(someService2.hashCode());

        if(someService1 == someService2)
        {
            System.out.println("someService1 和 someService2    是同一个对象");
        }
        else
        {
            System.out.println("someService1 和 someService2   不是同一个对象");
        }


    }



}
