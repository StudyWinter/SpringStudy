04-di-anno；使用注解来创建对象，给属性赋值。
用注解实现DI依赖注入

准备工作：
1、需要有spring-aop.jar
2、spring的配置文件要加入spring-context.xsd的约束文件

开发步骤:
1、新建吗maven；
2、加入spring的依赖，必须有spring-aop.jar；
3、新建类：在类中加入注解；
4、新建spring配置文件:声明组件扫描器标签，指定注解所在的包名；
5、新建测试类。