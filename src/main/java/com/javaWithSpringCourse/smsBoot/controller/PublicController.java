package com.javaWithSpringCourse.smsBoot.controller;

import com.javaWithSpringCourse.smsBoot.entity.Student;
import com.javaWithSpringCourse.smsBoot.exception.StudentNotFountException;
import com.javaWithSpringCourse.smsBoot.model.StudentDto;
import com.javaWithSpringCourse.smsBoot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by sailesh on 1/27/22.
 */
@RequestMapping("/api/v1")
@RestController
public class PublicController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity getAllStudents() {
        return new ResponseEntity<>(studentService.findAllStudent(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity getStudent(@PathVariable("id") Integer studentId) {
        return new ResponseEntity<>(studentService.findStudent(studentId), HttpStatus.OK);
    }


    @PostMapping("/students/create")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto student) {
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.OK);
    }

    @PutMapping("/students/{id}/update")
    public ResponseEntity updateStudent(@PathVariable("id") Integer studentId, @RequestBody StudentDto studentDto) {
        StudentDto studentDto1 = studentService.updateStudent(studentId, studentDto);
        if (studentDto1 == null) {
            throw new StudentNotFountException(studentId);
        }
        return new ResponseEntity<>(studentDto1, HttpStatus.OK);


    }
}
