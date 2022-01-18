package com.javaWithSpringCourse.smsBoot.entity;


import com.javaWithSpringCourse.smsBoot.model.Status;

import java.util.List;

/**
 * Created by sailesh on 1/12/22.
 */
public class Result {
    private Student student;
    private List<SubjectMark> subjectMarkList;
    private Double totalMarksObtained;
    private Status status;
    private Double percentage;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<SubjectMark> getSubjectMarkList() {
        return subjectMarkList;
    }

    public void setSubjectMarkList(List<SubjectMark> subjectMarkList) {
        this.subjectMarkList = subjectMarkList;
    }

    public Double getTotalMarksObtained() {
        return totalMarksObtained;
    }

    public void setTotalMarksObtained(Double totalMarksObtained) {
        this.totalMarksObtained = totalMarksObtained;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Result{" +
                "student=" + student +
                ", subjectMarkList=" + subjectMarkList +
                ", totalMarksObtained=" + totalMarksObtained +
                ", status=" + status +
                ", percentage=" + percentage +
                '}';
    }
}



