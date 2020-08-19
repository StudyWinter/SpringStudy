package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.example.beans.Student;

/**
 * 切面类：用来给业务方法增强功能的
 * @Aspect:是aspectj框架中的，表示当前类是切面类
 * 位置：累的定义上面
 *
 */
@Aspect
public class myAspect {
    //有功能增强的方法
    /**
     * 定义方法，实现功能增强，方法定义的格式：
     * 1、public方法
     * 2、一般都是void返回值（环绕通知除外）
     * 3、方法名称自定义
     * 4、方法可以有参数，参数类型有限制
     */

    /**
     * 1、@Before注解
     * 属性:value 表示切入点表达式，表示切面执行的位置
     * 位置：方法定义的上面
     *
     * 特点：
     * 1、在目标方法之前执行；
     * 2、不会影响目标方法的执行；
     * 3、不会改变目标方法的执行结果
     *
     * 这里方法的参数，如果是java基本类型和String类型，就直接写
     * 如果是自定义的类型，需要写全限定
     *  org.example.service.someService()
     */
  /*  @Before(value ="execution(* org.example.service.someServiceImpl.doSome())")
    public void myBefore(){
        //在方法中，实现业务的增强，例如日志代码
        System.out.println("前置通知：在目标方法之前，执行日志的功能");
    }*/


    /**
     * 获取doSome方法在执行时候信息，
     * 参数：JoinPoint:表示连接点(业务方法)   doSome/doOther
     *      连接点是切入点的一个业务方法
     */
   /* @Before(value ="execution(* org.example.service.someServiceImpl.do*(..))")
    public void myBefore(JoinPoint jp){                  //通知方法
        //在方法中，实现业务的增强，例如日志代码
       // System.out.println("前置通知：在目标方法之前，执行日志的功能");

        //获取方法的定义
        System.out.println("连接点的方法定义:"+jp.getSignature());
        System.out.println("连接点的方法名称" +jp.getSignature().getName());

        //获取方法只执行时的参数
        Object args[] = jp.getArgs();
        //遍历输出
        for (Object arg : args) {
            System.out.println(arg);
        }

        //根据参数值决定是否输出日志
        String name = (String) args[0];
        if("zhangsan".equals(name))
        {
            System.out.println("前置通知：在目标方法之前，执行日志的功能");
        }

    }*/


    /**
     * 2、@AfterReturing:后置通知
     *  属性：
     *      1、value：切入点表达式
     *      2、Returning：自定义的变量，表示目标方法的返回值的，
     *                   变量的名称必须和通知方法的参数名一样
     *
     *   位置：方法的上面
     *
     * 特点：
     * 1、在目标方法之后执行；
     * 2、【能够获取到目标方法的执行结果；】
     * 3、修改目标方法不会影响最后的执行结果
     *
     * Object result = org.example.service.someServiceImpl.doOther(..);
     * String
     * afterreturing(result);
     */

    @AfterReturning(value = "execution(* org.example.service.someServiceImpl.doOther(..))",returning = "result")
    public void afterreturing(Object result){

        //修改目标方法的返回值
        if(result!=null)
        {
            String str = (String) result;
            result = str.toUpperCase();     //字符串是一个final类型的数据，字符串转成大写,但是对调用没有影响
        }

        System.out.println("后置通知，在目标方法之后执行，能够获取目标方法的执行结果："+result);

    }


    /**
     *2、@AfterReturing:后置通知
     * 返回值是一个自定义类型
     * Object result = org.example.service.someServiceImpl.doOther(..);
     * Student对象，result成了引用，就可以修改了
     * afterreturing(result);
     */
    @AfterReturning(value = "execution(* org.example.service.someServiceImpl.doOther2(..))",returning = "result")
    public void afterreturing2(Object result){

        //修改目标方法的返回值
        if(result!=null)
        {
            Student student = (Student) result;
            student.setName("王五同学");
            student.setAge(1234);
        }

        System.out.println("后置通知222，在目标方法之后执行，能够获取目标方法的执行结果："+result);

    }


    /**
     * 3、@Around :环绕通知
     * 属性：value切入点表达式
     * 位置：方法定义的上面
     * 特点：
     *      1、在目标方法前后都可以增强功能；
     *      2、控制目标方法是否执行；
     *      3、修改目标方法的结果。
     *
     *环绕通知方法的定义
     * 1、有参数ProceedingJoinPoint
     * 2、有返回值，推荐使用Object
     *
     * myAround 等同于 InvocationHandler的invoke()
     * ProceedingJoinPoint extends JoinPoint
     *
     */
    @Around(value = "execution(* org.example.service.someServiceImpl.doFirst(..))")
    public Object myAround(ProceedingJoinPoint pdj) throws Throwable {
        //ProceedingJoinPoint能够获取连接点方法的定义，参数等信息
        String name = "";
        Object args[] = pdj.getArgs();    //拿到参数个数
        if(args.length>1)
        {
            name = (String) args[0];     //拿到第0个参数
        }

        Object result = null;

        //在目标方法之前打印日志
        System.out.println("环绕通知：在目标方法执行之前打印日志");

        //2、控制目标方法是否执行
        if("zs".equals(name))
        {
            //执行目标方法
            result = pdj.proceed();    //doFirst
        }


        //在目标方法之后加入事物处理
        System.out.println("环绕通知：在目标方法执行之后加入事物处理");

        //返回目标方法的执行结果（可以是修改后的结果）
        //3、修改目标方法的执行结果
        if(result!=null)
        {
            result = "Hello Aspectj";
        }
        return result;
    }


    /**
     * 4、@AfterThrowing 异常通知
     * 属性：  1、value：切入点表达式
     *        2、throwing:自定义的变量，表示目标方法抛出的异常对象，必须和通知方法的参数名一样
     * 位置：方法定义之上
     *
     * 特点：
     *      1、在目标方法抛出异常是执行的，可以看作是对目标方法监控
     *      2、不是异常处理程序，异常还是抛出
     *
     *      try{
     *          someServiceImpl.doSecond(..)
     *      }catch(Exception e){
     *          myAfterThrowing(e)
     *      }
     *      ...
     *
     *
     */
    @AfterThrowing(value = "execution(* org.example.service.someServiceImpl.doSecond(..))",throwing = "ex")
    public void myAfterThrowing(Throwable ex){       //ex代表抛出的异常

        //能获取异常发生的信息
        //项目中怎么处理异常呢？1、记录（数据库、日志）；2、发送通知（短信、邮件）

        System.out.println("异常通知：在目标方法抛出异常时执行的，异常原因： "+ex.getMessage());

    }


    /**
     * 5、最终通知
     * @After
     * 属性： value:切入点表达式
     * 位置：在方法定义的上面
     *
     * 特点： 1、在目标方法之后执行的；
     *       2、总是会被执行。
     */
    //@After(value = "execution(* org.example.service.someServiceImpl.doThird(..))")

    @After(value = "myPointCut()")
    public void  myAfter(){
        System.out.println("最终通知：总是会被执行，可以做程序最后要做的工作，例如资源回收、内存释放");
    }


    /**
     * @PointCut注解：用来定义和管理切入点
     *      属性：value：切入点表达式
     *      位置：自定义的方法上
     * 作用：@PointCut定义在方法的上面，这个方法的名称就是切入点的别名
     *      其他通知注解的value属性可以使用方法名称，表示切入点。
     *
     */
    @Pointcut(value = "execution(* org.example.service.someServiceImpl.doThird(..))")
    private void myPointCut(){                //这里方法名就代表切入点表达式了
        //无需代码
    }

    //测试没有接口的前置通知
    @Before(value = "execution(* org.example.service.orderServiceImpl.createOrder(..))")
    public void myOrder(){
        System.out.println("前置通知，在目标方法之前加入日志");
    }


}
