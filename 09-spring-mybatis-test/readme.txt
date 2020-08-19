09-spring-mybatis:spring整合Mybatis

步骤：
1、新建MySQL的库，student的表
2、加入依赖
    (1)spring的依赖；
                <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
                <dependency>
                    <groupId>org.springframework</groupId>
                    <artifactId>spring-context</artifactId>
                    <version>4.3.16.RELEASE</version>
                </dependency>

                <!--spring事物   Spring Transaction -->
                <!-- https://mvnrepository.com/artifact/org.springframework/spring-tx -->
                <dependency>
                    <groupId>org.springframework</groupId>
                    <artifactId>spring-tx</artifactId>
                    <version>4.3.16.RELEASE</version>
                </dependency>


                <!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
                <dependency>
                    <groupId>org.springframework</groupId>
                    <artifactId>spring-jdbc</artifactId>
                    <version>4.3.16.RELEASE</version>
                </dependency>


    (2)mybatis的依赖；
                <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
                <dependency>
                    <groupId>org.mybatis</groupId>
                    <artifactId>mybatis</artifactId>
                    <version>3.4.5</version>
                </dependency>

    (3)mybatis-spring的依赖，这个jar包从Mybatis官网下载的，Mybatis提供在spring中创建对象的类；
                <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
                <dependency>
                    <groupId>org.mybatis</groupId>
                    <artifactId>mybatis-spring</artifactId>
                    <version>1.3.1</version>
                </dependency>
    (4)mysql的驱动；

                <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
                <dependency>
                    <groupId>mysql</groupId>
                    <artifactId>mysql-connector-java</artifactId>
                    <version>5.1.9</version>
                </dependency>
    (5)druid,数据库连接池的依赖
                <!-- https://mvnrepository.com/artifact/com.alibaba/druid -->
                <dependency>
                    <groupId>com.alibaba</groupId>
                    <artifactId>druid</artifactId>
                    <version>1.1.12</version>
                </dependency>



                <resources>
                      <resource>
                        <directory>src/main/java</directory><!--所在的目录-->
                        <includes><!--包括目录下的. properties, . xml文件都会扫描到-->
                          <include>**/* . properties </include>
                          <include>**/* . xml </include>
                        </includes>
                        <filtering>false</filtering>
                      </resource>
                    </resources>

3、新建实体类Student

4、新建Dao接口和SQL映射文件

5、新建Mybatis主配置文件

6、新建Service接口和实现类，在实现类中有Dao的属性

7、新建spring的配置文件
    (1)声明数据源DataSource对象
    (2)声明SqlSessionFactoryBean，创建SqlSessionFactory对象
    (3)声明Mybatis的扫描器，创建Dao接口的实现类对象
    (4)声明自定义的Service，把(3)中的Dao对象注入赋值给Service的属性

8、新建测试类，从spring容器中获取Service，调用Service的方法，完成对数据库的操作


