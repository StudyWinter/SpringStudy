package org.example.service;

import org.example.beans.Student;

import java.util.List;

public interface StudentService {

    //添加
    int addStudent(Student student);

    //查询
    List<Student> queryStudents();

}
