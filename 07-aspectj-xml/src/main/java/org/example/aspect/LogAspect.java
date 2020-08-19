package org.example.aspect;

public class LogAspect {

    /**
     *   定义方法，实现切面的功能
     *   方法的定义方式同注解方式中的各个方法。前置通知 同 @Before方法的定义
     */

    public void recordLog(){
        System.out.println("前置通知：在目标方法之前记录日志");
    }


}
