01-primary:第一个spring项目，学习Ioc

步骤：
1、新建Maven工程
2、加入Spring 的依赖
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>4.3.16.RELEASE</version>
</dependency>
3、创建类（接口和实现类，也可以没有接口）：和没有使用框架一样。
4、新建spring的配置文件（xml）
    声明对象，这个对象是Spring容器声明和管理的。

5、新建测试类，验证Spring的容器使用。
    创建表示Spring的对象ApplicationContext
    从Spring容器中获取对象只有getBean()


6、build加入

<plugins>
    <plugin>
        <artifactId>maven-compiler-plugin</artifactId>
        <version>3.1</version>
        <configuration>
            <source>1.8</source>
            <target>1.8</target>
        </configuration>
    </plugin>
</plugins>
