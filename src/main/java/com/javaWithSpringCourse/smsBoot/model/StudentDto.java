package com.javaWithSpringCourse.smsBoot.model;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;

/**
 * Created by sailesh on 1/27/22.
 */
public class StudentDto extends RepresentationModel<StudentDto> {
    private String name;
    private Integer age;
    private String gender;
    private String address;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date dob;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
