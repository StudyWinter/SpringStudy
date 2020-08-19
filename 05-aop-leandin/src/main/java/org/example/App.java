package org.example;

import org.example.proxy.MyInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * 普通的业务形式
     *
     */
  /*  public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        //创建对象
        SomeService someService = new SomeServiceImpl();

        //调用方法
        someService.doSome();;
        System.out.println("==============================");
        someService.doOther();
    }*/

    /**
     * 动态代理实现
     *
     * */
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        //创建目标对象
        SomeService target = new SomeServiceImpl();

        //创建InvocationHandler的实现类对象
        MyInvocationHandler Handler = new MyInvocationHandler(target);

        //创建代理对象
        /*
         * 第一个参数，目标对象的类加载器
         * 第二个参数，目标对象的接口
         *
         */

        SomeService proxy = (SomeService) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                Handler);


        ////com.sun.proxy.$Proxy0  这个jdk的动态代理类型
        System.out.println("proxy: "+proxy.getClass().getName());

        //通过代理对象执行业务方法，实现功能的增强，当执行proxy.doSome()的时候，实际执行的是Handler对象的invoke方法
        proxy.doSome();
        System.out.println("=======================");
        proxy.doOther();;

    }



}
