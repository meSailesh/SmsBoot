package com.javaWithSpringCourse.smsBoot.repository;

import com.javaWithSpringCourse.smsBoot.entity.Student;

import java.util.List;

/**
 * Created by sailesh on 1/25/22.
 */
public interface StudentRepositoryCustom {

    Student saveStudent(Student student);
    Student findStudent(Integer studentId);
    List<Student> findStudent(String studentName);
    List<Student> findAllStudent();
    Student updateStudent(Student student);
    Student deleteRecord(Student student);
}
