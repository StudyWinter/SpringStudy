package org.example.ba01;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * 要创建Student类的对象
 * @Component   :创建类的对象，等同于<bean> 标签，默认是单例对象。
 *      属性：value 表示对象的名称，等同于<bean>的id
 *      位置：类定义的上面，表示创建累类的对象
 *
 *      @Component(value = "myStudent")等同于
 *      <>bean id="myStudent" class="org.example.ba01.Student"/>
 *
 *      和@Component注解功能相同的其他注解
 *      1、@Repository :放在Dao层的实现类上面，目的是为了创建Dao对象。这样的对象是访问数据库；
 *      2、@Service:放在Service层的实现类上面，目的是为了创建Service对象，表示业务层对象，能够有事物功能；
 *      3、@Controller:放在处理器类的上面，目的是为了创建处理器对象，处理器对象接受用户的请求
 *
 *      @Repository、@Service、@Controller都能创建对象，除此之外还有其他功能。
 *      使用这三个注解，能够分层
 *      Component可以看作是父类，其他三个可以看作是子类
 *
 */
//创建Student类的对象，名称叫做myStudent,对象存放在spring容器中。
//@Component(value = "myStudent1")

//省略value
//@Component("myStudent2")

//不知道对象的名称，框架会默认给对象名称，默认的是类名的首字母小写
//@Component


@Component("myStudent")
public class Student {

    private String name;
    private int age;

    //setter方法
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }


    //toString方法
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
