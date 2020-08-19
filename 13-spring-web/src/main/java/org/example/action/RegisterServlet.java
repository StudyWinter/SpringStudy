package org.example.action;

import org.example.beans.Student;
import org.example.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {


    //doGet里面调用doPost
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    /**
     * 容器对象创建的问题：
     * 1、容器对象创建多次，导致配置文件中的对象也创建多次，导致对象会占用内存，过多的gc
     *      容器对象只需创建一次：【监视器】
     *
     * 2、容器对象在整个项目中应该是共享使用的
     *      把容器对象对象放在全局作用域，ServletContext
     */


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String strName = req.getParameter("name");
        String strAge = req.getParameter("age");

        //创建spring容器
        //定义配置文件
        String config = "applicationContext.xml";

        //生成容器对象
        ApplicationContext alc = new ClassPathXmlApplicationContext(config);

        //输出容器对象
        System.out.println("容器对象 ："+alc);

        //从spring容器中获取service
        StudentService service = (StudentService) alc.getBean("studentService");

        Student student = new Student();
        student.setName(strName);
        student.setAge(Integer.parseInt(strAge));

        service.addStudent(student);

        req.getRequestDispatcher("/result.jsp").forward(req,resp);


    }
}
