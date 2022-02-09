package com.javaWithSpringCourse.smsBoot.entity;

import javax.persistence.*;

/**
 * Created by sailesh on 1/12/22.
 */
@Entity
@Table(name = "subject_mark")
public class SubjectMark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer subjectMarkID;
    private Integer studentId;
    private Integer subjectId;
    private Double marks;


    @ManyToOne()
    @JoinColumn(name="student_ref_id")
    private Student student;

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String toCsvString() {
        return subjectMarkID + "," + studentId + "," + subjectId + "," + marks;
    }
}
