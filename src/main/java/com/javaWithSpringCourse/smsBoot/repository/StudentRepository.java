package com.javaWithSpringCourse.smsBoot.repository;


import com.javaWithSpringCourse.smsBoot.entity.Student;

import java.util.List;

/**
 * Created by sailesh on 1/6/22.
 */
public interface StudentRepository {

    Student saveStudent(Student student);
    Student findStudent(Integer studentId);
    List<Student> findStudent(String studentName);
    List<Student> findAllStudent();
    Student updateStudent(Student student);
    Student deleteStudent(Student student);
}