08-spring-aop:使用spring框架实现AOP

重要步骤：
1、实现通知的接口，例如环绕通知MethodInterceptor；
2、在spring的配置文件声明，声明ProxyFactoryBean,创建目标对象的代理对象；
        ProxyFactoryBean等同于jdk动态代理中的Proxy


步骤：
1、新建maven对象
2、加入依赖
    （1）spring的依赖



3、新建业务接口和实现类。要给业务方法增强功能

4、新建实现接口的类(InvocationHandel)
   在类中重写方法，实现功能的增强


5、新建spring的配置文件
    (1)声明目标类对象；
    (2)声明切面类对象；
    (3)声明ProxyFactoryBean，创建目标对象的代理对象

6、新建测试类，从spring容器中获取对象，通过这个对象执行业务方法，实现功能的增强。
