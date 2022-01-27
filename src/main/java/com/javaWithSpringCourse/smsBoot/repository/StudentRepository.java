package com.javaWithSpringCourse.smsBoot.repository;


import com.javaWithSpringCourse.smsBoot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by sailesh on 1/6/22.
 */
public interface StudentRepository extends JpaRepository<Student, Integer>, StudentRepositoryCustom{

    Student findByName(String name);



}