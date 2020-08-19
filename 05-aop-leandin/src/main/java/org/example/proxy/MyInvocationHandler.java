package org.example.proxy;

/**
 * InvocationHandler接口：在接口的实现类中，重写invoke()，实现功能的增强。
 */

import org.example.utils.ServiceTools;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocationHandler implements InvocationHandler {

    //通过构造方法或者代理方法把要代理的对象传入进来
    private Object target;

    //构造方法
    public MyInvocationHandler() {
    }
    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    /**
     * 重写invoke方法
     *  实现业务方法功能的增强，【加入日志】、【事物功能】。
     * @param proxy  ：系统生成的代理对象
     * @param method ：业务方法，对应的就是doSome和doOther
     * @param args   ：业务方法参数
     * @return       ：Object业务方法的返回值，即方法的执行结果
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;

        //希望给doSome方法加入功能，doOther不加入
        System.out.println("method's name  "+method.getName());  //可以输出doSome和doOther

        //对方法的名称加以判断
        String name = method.getName();
        //当前的方法是doSome方法
        if("doSome".equals(name))
        {
            //在目标方法调用之前加入日志
            ServiceTools.doLog();

            //执行目标方法，target是目标对象，args是目标方法参数
            result = method.invoke(target,args);     //相当于doSome

            //在目标方法之后加入事物
            ServiceTools.doTrans();
        }
         else
        {
            //doOther方法
            //执行目标方法
            result = method.invoke(target,args);     //相当于doOther
        }


        //目标方法的执行结果
        return result;
    }
}
