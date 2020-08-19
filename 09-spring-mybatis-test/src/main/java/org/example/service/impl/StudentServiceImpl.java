package org.example.service.impl;

import org.example.beans.Student;
import org.example.dao.StudentDao;
import org.example.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    //定义依赖对象Dao
    private StudentDao stuDao;

    //set方法，设置注入，在配置文件中给dao赋值
    public void setStuDao(StudentDao stuDao) {
        this.stuDao = stuDao;
    }

    @Override
    public int addStudent(Student student) {
        int nums = stuDao.insertStudent(student);
        return nums;
    }

    @Override
    public List<Student> queryStudents() {
        List<Student> students = stuDao.selectStudents();
        return students;
    }
}
