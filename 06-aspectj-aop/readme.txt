06-aspectj-aop:使用aspectj框架，用注解实现AOP

步骤：
1、新建maven对象
2、加入依赖
    （1）spring的依赖


    （2）aspectj的依赖

             <!-- https://mvnrepository.com/artifact/org.springframework/spring-aspects -->
                       <dependency>
                           <groupId>org.springframework</groupId>
                           <artifactId>spring-aspects</artifactId>
                           <version>4.3.16.RELEASE</version>
                       </dependency>
3、新建业务接口和实现类。要给业务方法增强功能

4、新建切面类
    （1）在类的定义上加入@Aspect
    (2)在类中自定义方法，实现切面的功能代码。
    在方法的上面加入aspectj中的通知注解，例如@Before

5、新建spring的配置文件
    (1)声明目标类对象；
    (2)声明切面类对象；
    (3)通过spring和aspectj，创建目标对象的代理。

6、新建测试类，从spring容器中获取对象，通过这个对象执行业务方法，实现功能的增强。
