package com.javaWithSpringCourse.smsBoot.service;


import com.javaWithSpringCourse.smsBoot.entity.Student;
import com.javaWithSpringCourse.smsBoot.repository.FileStudentRepository;
import com.javaWithSpringCourse.smsBoot.repository.StudentRepository;

import java.util.List;

/**
 * Created by sailesh on 1/4/22.
 */
public class StudentService {
    StudentRepository studentRepository = new FileStudentRepository();

    public Student createStudent(Student student) {
        //todo check if the data is valid
        //todo persist the data
        Student student1 = studentRepository.saveStudent(student);
        return student;

    }

    public Student findStudent(Integer studentId) {
        return studentRepository.findStudent(studentId);
    }

    public List<Student> findStudent(String studentName) {
        return studentRepository.findStudent(studentName);
    }

    public List<Student> findAllStudent() {
      return studentRepository.findAllStudent();
    }

    public Student updateStudent(Student student) {
        //get request from user, and perform any operation before persisting
//        Date dob = student.getDob();
//        Long age = new Date().getTime() - dob.getTime();
//        student.setAge(age.intValue());
        return studentRepository.updateStudent(student);
    }

    public Student deleteStudent(Student student) {
        return studentRepository.deleteStudent(student);
    }
}


