package org.example;

import org.example.service.BuyGoodsService;
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

        //声明容器对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);  //构造方法

        /*String names [] = alc.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }*/


       //从容器中获取对象
        BuyGoodsService service = (BuyGoodsService) alc.getBean("buyService");

        //输出
        System.out.println("service "+service.getClass().getName());



        /*//购买商品
        service.buyGoods(1001,2);
        System.out.println("购买商品完成");*/

        /*//测试库存不足
        service.buyGoods(1001,100);
        System.out.println("购买商品完成");*/

        //测试没有该商品
        service.buyGoods(1005,23);
        System.out.println("购买商品完成");

    }
}
