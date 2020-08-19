13、spring-web:在web中使用spring，spring容器管理service、dao等对象

此功能没有实现

准备工作：
1、创建java、resources目录
2、修改web.xml中的servlet的版本


加入监听器ContextLoaderListener
作用：
    1、在初始方法中，创建spring容器对象
    2、把创建好的容器对象放到ServletContext中


     <dependency>
          <groupId>org.springframework</groupId>
          <artifactId>spring-web</artifactId>
          <version>4.3.16.RELEASE</version>
     </dependency>



步骤：
1、新建maven web
2、加入依赖
3、拷贝09-spring-Mybatis的src、配置文件
4、新建jsp，提交请求，有参数name、age
5、新建servlet，接受用户的请求，创建spring的容器，调用service的方法
6、新建作为结果的jsp
7、修改web.xml,注册自定义的servlet