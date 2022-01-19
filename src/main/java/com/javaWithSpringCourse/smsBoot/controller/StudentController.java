package com.javaWithSpringCourse.smsBoot.controller;

import com.javaWithSpringCourse.smsBoot.entity.Student;
import com.javaWithSpringCourse.smsBoot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by sailesh on 1/19/22.
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/all")
    public String getStudentsPage(Model model) {
        List<Student> students = studentService.findAllStudent();
        model.addAttribute("students", students);;
        return "student/students";
    }

    @GetMapping("/create")
    public String createStudentPage( Model model) {
        model.addAttribute("student", new Student());
        return "student/create-student";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("student")Student student, Model model) {
        Student savedStudent = studentService.createStudent(student);
        if(savedStudent != null) {
            return "student/students";
        }
        model.addAttribute("error", "Couldnot create student. Please retry");
        return "student/create-student";
    }
}
