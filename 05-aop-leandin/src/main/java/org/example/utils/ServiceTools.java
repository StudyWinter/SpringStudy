package org.example.utils;

import java.util.Date;

/**
 * 工具类
 */

public class ServiceTools {


    //希望在执行方法的时候，打印日志。日志功能与方法具体的业务没有直接关系
    public static void doLog(){
        System.out.println("非业务：日志功能，在方法开始时记录日志 "+new Date());
    }

    //事物功能，希望在方法之后执行
    public static void doTrans(){
        System.out.println("非业务功能，在方法结束后执行");
    }

}
