package com.javaWithSpringCourse.smsBoot.service;


import com.javaWithSpringCourse.smsBoot.controller.PublicController;
import com.javaWithSpringCourse.smsBoot.entity.Student;
import com.javaWithSpringCourse.smsBoot.exception.StudentNotFoundException;
import com.javaWithSpringCourse.smsBoot.model.*;
import com.javaWithSpringCourse.smsBoot.repository.FileStudentRepository;
import com.javaWithSpringCourse.smsBoot.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

/**
 * Created by sailesh on 1/4/22.
 */

@Service
public class StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student student) {
        //todo check if the data is valid
        //todo persist the data
        Student student1 = studentRepository.save(student);
        return student1;

    }

    public StudentDto createStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        Student student1 = studentRepository.save(student);
        BeanUtils.copyProperties(student1, studentDto);
//        studentDto.add(linkTo(methodOn(PublicController.class).getAllStudent()).withRel("list"));
        studentDto.add(linkTo(methodOn(PublicController.class).getStudent(student1.getId())).withSelfRel());
        return studentDto;

    }

    public Student findStudent(Integer studentId) throws StudentNotFoundException{
       try{
           return studentRepository.findById(studentId).get();
       } catch (Exception e) {
           System.out.println("studentId = " + studentId);
           throw new StudentNotFoundException(studentId);
       }
    }

    public Student findStudent(String studentName) {
        return studentRepository.findByName(studentName);
    }

    public List<Student> findAllStudent() {
        logger.info("Finding student details");
      List<Student> students = studentRepository.findAll();
      logger.debug("Student details fetched. Records:{}", students);
      logger.error("Test log for error");
      logger.info("Student details fetched. Found {} records. Returning the records", students.size());
      Integer i =10;
      return students;
    }

    public com.javaWithSpringCourse.smsBoot.model.PageRequest findAllStudentWithPagingAndSorting(Integer page, Integer size, String sortBy) {
        logger.info("Finding student details for page {} with size {} and sortBy {}", page, size, sortBy);
        Pageable pageable = PageRequest.of(page,size, Sort.by(sortBy).ascending());


        Slice<Student> studentSlice = studentRepository.findAllBy(pageable);
        List<Student> students = studentSlice.getContent();

        com.javaWithSpringCourse.smsBoot.model.PageRequest pageRequest = new com.javaWithSpringCourse.smsBoot.model.PageRequest();
        pageRequest.setContents(students);
        pageRequest.setNumberOfElements(studentSlice.getNumberOfElements());
        pageRequest.setPageNumber(studentSlice.getNumber());
        pageRequest.setPageSize(studentSlice.getSize());
        pageRequest.setSortBy(sortBy);
        pageRequest.setSorted(studentSlice.getSort().isSorted());

        if(studentSlice.hasNext()) {
            Integer nextPage = studentSlice.getNumber() + 1;
            pageRequest.add(linkTo(methodOn(PublicController.class).getAllStudent(nextPage, size, sortBy)).withRel("next"));
        }

        if(studentSlice.hasPrevious()) {
            Integer nextPage = studentSlice.getNumber() - 1;
            pageRequest.add(linkTo(methodOn(PublicController.class).getAllStudent(nextPage, size, sortBy)).withRel("previous"));
        }



        return pageRequest;
    }

    public Student updateStudent(Student student) {
        //get request from user, and perform any operation before persisting
//        Date dob = student.getDob();
//        Long age = new Date().getTime() - dob.getTime();
//        student.setAge(age.intValue());
        return studentRepository.save(student);
    }

    public StudentDto findStudentDto(Integer studentId) throws StudentNotFoundException{
        try{
            StudentDto studentDto = new StudentDto();
            Student student = studentRepository.findById(studentId).get();
            BeanUtils.copyProperties(student,studentDto);
//            studentDto.add(linkTo(methodOn(PublicController.class).getAllStudent()).withRel("findAll"));
            return studentDto;
        } catch (Exception e) {
            System.out.println("studentId = " + studentId);
            throw new StudentNotFoundException(studentId);
        }
    }

    public Student updateStudent(Integer studentId, Student student) throws StudentNotFoundException{
        Student existingStudent = findStudent(studentId);

        for(int i=0; i<100; i++) {
            logger.info("The number is {} ", i);
        }
        if(existingStudent != null) {
            BeanUtils.copyProperties(student, existingStudent);
            existingStudent.setId(studentId);
            updateStudent(existingStudent);
            return  existingStudent;
        } else {
            throw new StudentNotFoundException(studentId);
        }
    }

    public Student deleteStudent(Student student) {
        studentRepository.delete(student);
        return student;
    }

    public Student deleteStudent(Integer studentId) throws Exception{
        Student student = findStudent(studentId);
        return deleteStudent(student);
    }


}


