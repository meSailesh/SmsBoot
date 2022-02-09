package com.javaWithSpringCourse.smsBoot.repository;


import com.javaWithSpringCourse.smsBoot.entity.SubjectMark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by sailesh on 1/12/22.
 */
public interface SubjectMarkRepository extends JpaRepository<SubjectMark, Integer>{


}
