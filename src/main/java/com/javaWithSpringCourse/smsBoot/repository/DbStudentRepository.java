package com.javaWithSpringCourse.smsBoot.repository;


import com.javaWithSpringCourse.smsBoot.entity.Student;

import java.util.List;

/**
 * Created by sailesh on 1/6/22.
 */
public class DbStudentRepository implements StudentRepository {

    public Student saveStudentToDb(Student student) {
        return  null;
    }

    @Override
    public Student saveStudent(Student student) {
        return null;
    }

    @Override
    public Student findStudent(Integer studentId) {
        return null;
    }

    @Override
    public List<Student> findStudent(String studentName) {
        return null;
    }

    @Override
    public List<Student> findAllStudent() {
        return null;
    }

    @Override
    public Student updateStudent(Student student) {
        return null;
    }

    @Override
    public Student deleteStudent(Student student) {
        return null;
    }
}
