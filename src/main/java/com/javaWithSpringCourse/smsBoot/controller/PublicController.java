package com.javaWithSpringCourse.smsBoot.controller;

import com.javaWithSpringCourse.smsBoot.entity.Role;
import com.javaWithSpringCourse.smsBoot.entity.Student;
import com.javaWithSpringCourse.smsBoot.entity.SubjectMark;
import com.javaWithSpringCourse.smsBoot.entity.User;
import com.javaWithSpringCourse.smsBoot.exception.StudentNotFoundException;
import com.javaWithSpringCourse.smsBoot.model.PageRequest;
import com.javaWithSpringCourse.smsBoot.model.StudentDto;
import com.javaWithSpringCourse.smsBoot.service.ExamResultService;
import com.javaWithSpringCourse.smsBoot.service.RoleService;
import com.javaWithSpringCourse.smsBoot.service.StudentService;
import com.javaWithSpringCourse.smsBoot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by sailesh on 1/28/22.
 */
@RequestMapping("/api/v1")
@RestController
public class PublicController {

    @Autowired
    StudentService studentService;

//    @ExceptionHandler(value = StudentNotFoundException.class)
//    public ResponseEntity<?> handleStudentNotFoundException(StudentNotFoundException ex) {
//        ErrorResponse errorResponse = new ErrorResponse(
//                HttpStatus.BAD_REQUEST.value(),
//                ex.getMessage(),
//                new Date(),
//                HttpStatus.BAD_REQUEST.getReasonPhrase()
//        );
//
//        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//    }

    @PostMapping("/students/create")
    public ResponseEntity<?> createStudent(@RequestBody Student student) {
    StudentDto savedStudent = studentService.createStudentDto(student);
    return new ResponseEntity<Object>(savedStudent, HttpStatus.OK);
    }

    @GetMapping("/students")
    public ResponseEntity<PageRequest> getAllStudent(@RequestParam(defaultValue = "0" , name = "page",required = false) Integer page,
                                                     @RequestParam(defaultValue = "5", name = "size", required = false) Integer size,
                                                     @RequestParam(defaultValue = "name", name = "sortBy", required = false) String sortBy) {
        return new ResponseEntity<>(studentService.findAllStudentWithPagingAndSorting(page, size, sortBy), HttpStatus.OK);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<?> getStudent(@PathVariable("id") Integer studentId) {
        return new ResponseEntity<>(studentService.findStudentDto(studentId), HttpStatus.OK);
    }


    @PutMapping("/students/{id}/update")
    public Student updateStudent(@PathVariable("id") Integer studentId, @RequestBody Student student) {
        return studentService.updateStudent(studentId, student);
    }

    @DeleteMapping("/students/{id}/delete")
    public Student updateStudent(@PathVariable("id") Integer studentId) throws Exception {
        return studentService.deleteStudent(studentId);
    }

    @PostMapping("/students/upload")
    public ResponseEntity<?> uploadStudent(@RequestParam(name = "file")MultipartFile file) throws Exception {
        studentService.uploadStudentRecord(file);
        return  new ResponseEntity<Object>(HttpStatus.OK);
    }

    @GetMapping("/students/download")
    public ResponseEntity<?> downloadStudents(HttpServletResponse response) throws Exception {
        studentService.downloadStudentRecords(response);
        return  new ResponseEntity<Object>(HttpStatus.OK);
    }

    @Autowired
    RoleService roleService;

    @Autowired
    UserService userService;


    @PostMapping("/roles/create")
    public Role createRole(@RequestBody Role role){
        return roleService.createRole(role);
    }

    @PostMapping("/users/create")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }


    @GetMapping("/roles/{id}")
    public Role getRole(@PathVariable(name = "id") Integer roleId){
        return roleService.getRole(roleId);
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable(name = "id") Long userId){
        return userService.getUser(userId);
    }

    @PostMapping("users/{id}/assignRole")
    public User assignRoleToUser(@PathVariable(name = "id") Long userId, @RequestParam(name = "roleId") Integer roleId) {
        return userService.assignRoleToUser(userId, roleId);
    }

    @DeleteMapping("users/{id}/delete")
    public ResponseEntity<?> deleteUser(@PathVariable(name = "id") Long userId) {
        userService.deleteUser(userId);
        return new ResponseEntity(HttpStatus.OK);


    }

    @Autowired
    ExamResultService examResultService;


    @PostMapping("students/insert-mark")
    public SubjectMark creteSubjectMark(@RequestBody SubjectMark subjectMark) {

        return examResultService.createSubjectMark(subjectMark);





    }


}
