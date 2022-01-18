package com.javaWithSpringCourse.smsBoot.entity;

/**
 * Created by sailesh on 1/12/22.
 */
public class SubjectMark {
    private Integer subjectMarkID;
    private Integer studentId;
    private Integer subjectId;
    private Double marks;

    public Integer getSubjectMarkID() {
        return subjectMarkID;
    }

    public void setSubjectMarkID(Integer subjectMarkID) {
        this.subjectMarkID = subjectMarkID;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }


    public String toCsvString() {
        return subjectMarkID + "," + studentId + "," + subjectId + "," + marks;
    }
}
