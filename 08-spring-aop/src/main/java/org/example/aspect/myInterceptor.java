package org.example.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * MethodInterceptor等同于InvocationHandler
 * invoke  == invoke
 *
 * 环绕通知
 *
 */

public class myInterceptor implements MethodInterceptor {

    //MethodInvocation  == jdk中的Method

    //实现接口中的方法
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        Object result = null;

        System.out.println("spring的环绕通知：在目标方法之前执行的功能");

        //实现功能的增强，目标方法的调用
        result = invocation.proceed();

        System.out.println("spring的环绕通知：在目标方法之后执行的功能");

        return result;
    }
}
