13、spring-web:在web中使用spring，spring容器管理service、dao等对象

准备工作：
1、创建java、resources目录
2、修改web.xml中的servlet的版本


步骤：
1、新建maven web
2、加入依赖
3、拷贝09-spring-Mybatis的src、配置文件
4、新建jsp，提交请求，有参数name、age
5、新建servlet，接受用户的请求，创建spring的容器，调用service的方法
6、新建作为结果的jsp
7、修改web.xml,注册自定义的servlet