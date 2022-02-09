package com.javaWithSpringCourse.smsBoot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by sailesh on 1/5/22.
 */
@Entity
@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "address")
    private String address;

    @Column(name = "gender")
    private String gender;

    @Column(name = "dob")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private List<SubjectMark> subjectMarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public List<SubjectMark> getSubjectMarks() {
        return subjectMarks;
    }

    public void setSubjectMarks(List<SubjectMark> subjectMarks) {
        this.subjectMarks = subjectMarks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                '}';
    }

    public  String toCsvString() {
        return id + "," +
                name + "," +
                age + "," +
                address + "," +
                gender + "," +
                dob;
    }
}
