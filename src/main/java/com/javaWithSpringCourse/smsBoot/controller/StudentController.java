package com.javaWithSpringCourse.smsBoot.controller;

import com.javaWithSpringCourse.smsBoot.entity.Student;
import com.javaWithSpringCourse.smsBoot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        model.addAttribute("students", students);
        return "student/students";
    }

    @GetMapping("/create")
    public String createStudentPage( Model model) {
        model.addAttribute("student", new Student());
        return "student/create-student";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("student")Student student, Model model, RedirectAttributes redirectAttributes) {
        Student savedStudent = studentService.createStudent(student);
        if(savedStudent != null) {
            redirectAttributes.addFlashAttribute("message", "Student Created Successfully");
            return "redirect:/student/all";
        }
        model.addAttribute("error", "Couldnot create student. Please retry");
        return "student/create-student";
    }


    @GetMapping("/{id}")
    public String viewStudentPage(@PathVariable(value = "id")Integer studentId, Model model) {
        Student student = studentService.findStudent(studentId);
        model.addAttribute("student", student);
        return "student/student-detail";
    }

    @GetMapping("/update/{id}")
    public String updateStudentPage(@PathVariable(value = "id") Integer studentId, Model model) {
        Student student = studentService.findStudent(studentId);
        model.addAttribute("student", student);
        return "student/student-update";
    }

    @PostMapping("/update")
    public String updateStudent(@ModelAttribute("student")Student student, Model model, RedirectAttributes redirectAttributes) {
        Student updateStudent = studentService.updateStudent(student);
        if(updateStudent != null) {
            redirectAttributes.addFlashAttribute("message", "Student updated Successfully");
            return "redirect:/student/all";
        }
        model.addAttribute("error", "Couldnot update student. Please retry");
        return "student/student-update";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable(value = "id") Integer studentId, RedirectAttributes redirectAttributes) {
        Student deletedStudent = studentService.deleteStudent(studentId);
        if(deletedStudent != null) {
            redirectAttributes.addFlashAttribute("message", "Student deleted Successfully");
        } else {
            redirectAttributes.addFlashAttribute("error", "Error deleting student information. Retry again!");
        }
        return "redirect:/student/all";
    }
}
