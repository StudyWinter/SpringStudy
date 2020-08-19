package org.example.dao;

import org.example.beans.Student;

import java.util.List;

public interface StudentDao {

    //添加
    int insertStudent(Student student);

    //查询
    List<Student> selectStudents();
}
