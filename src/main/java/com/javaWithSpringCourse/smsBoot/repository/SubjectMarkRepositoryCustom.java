package com.javaWithSpringCourse.smsBoot.repository;

import com.javaWithSpringCourse.smsBoot.entity.SubjectMark;

import java.util.List;

/**
 * Created by sailesh on 2/8/22.
 */
public interface SubjectMarkRepositoryCustom {
    List<SubjectMark> createSubjectMark(List<SubjectMark> subjectMarks);
    List<SubjectMark> getAllSubjectMarks(Integer studentId);
}
