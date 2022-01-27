package com.javaWithSpringCourse.smsBoot.service;


import com.javaWithSpringCourse.smsBoot.controller.PublicController;
import com.javaWithSpringCourse.smsBoot.entity.Student;
import com.javaWithSpringCourse.smsBoot.exception.StudentNotFountException;
import com.javaWithSpringCourse.smsBoot.model.StudentDto;
import com.javaWithSpringCourse.smsBoot.repository.FileStudentRepository;
import com.javaWithSpringCourse.smsBoot.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Created by sailesh on 1/4/22.
 */

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        //todo check if the data is valid
        //todo persist the data
        Student student1 = studentRepository.save(student);
        return student1;

    }

    public StudentDto createStudent(StudentDto studentDto) {
        //todo check if the data is valid
        //todo persist the data
        Student student = new Student();
        BeanUtils.copyProperties(studentDto, student);
        Student savedStudent = createStudent(student);
        BeanUtils.copyProperties(savedStudent, studentDto);
        studentDto.add(linkTo(methodOn(PublicController.class).getAllStudents()).withRel("listStudent"));
        studentDto.add(linkTo(methodOn(PublicController.class).getStudent(student.getId())).withRel("viewStudent"));
        return studentDto;
    }

    public Student findStudent(Integer studentId) {
        return studentRepository.findById(studentId).orElseThrow(() ->new StudentNotFountException(studentId));
    }

    public Student findStudent(String studentName) {
        return studentRepository.findByName(studentName);
    }

    public List<Student> findAllStudent() {
      return studentRepository.findAll();
    }

    public Student updateStudent(Student student) {
        //get request from user, and perform any operation before persisting
//        Date dob = student.getDob();
//        Long age = new Date().getTime() - dob.getTime();
//        student.setAge(age.intValue());
        return studentRepository.save(student);
    }

    public StudentDto updateStudent(Integer studentId, StudentDto studentDto) {
        Student existingStudent = findStudent(studentId);
        if(existingStudent != null) {
            BeanUtils.copyProperties(studentDto, existingStudent);
            Student savedStudent = updateStudent(existingStudent);
            BeanUtils.copyProperties(studentDto, savedStudent);
            studentDto.add(linkTo(methodOn(PublicController.class).getStudent(studentId)).withSelfRel());
            return  studentDto;
        }
        return  null;
    }

    public Student deleteStudent(Student student) {
        studentRepository.delete(student);
        return student;
    }

    public Student deleteStudent(Integer studentId) {
        Student student = findStudent(studentId);
        return deleteStudent(student);
    }


}


