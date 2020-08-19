package org.example;

/**
 * 用动态代理实现【打印日志功能】和【加入事物功能】
 *
 * InvocationHandler接口：在接口的实现类中，重写invoke()，实现功能的增强。
 */

public class SomeServiceImpl implements SomeService {
    public void doSome() {
        //调用打印日志功能
       // ServiceTools.doLog();

       // doLog();

        System.out.println("执行了业务方法doSome");

        //doTrans();
        //加入事物
        //ServiceTools.doTrans();;
    }

    public void doOther() {
        //调用打印日志功能
        //ServiceTools.doLog();

       // doLog();
        System.out.println("执行了业务方法doOther");
        //doTrans();

        //加入事物
        //ServiceTools.doTrans();
    }


    //日志功能
   /* public void doLog(){
        System.out.println("非业务日志功能，在方法开始的时候记录日志 "+new Date());
    }

    //事物功能
    public void doTrans(){
        System.out.println("非业务事物功能，在方法执行结束后执行");
    }*/


}
