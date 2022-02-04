package com.javaWithSpringCourse.smsBoot.controller;

import com.javaWithSpringCourse.smsBoot.entity.Student;
import com.javaWithSpringCourse.smsBoot.model.PageRequest;
import com.javaWithSpringCourse.smsBoot.model.StudentDto;
import com.javaWithSpringCourse.smsBoot.service.StudentService;
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
}
