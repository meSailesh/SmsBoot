package com.javaWithSpringCourse.smsBoot.model;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.util.Date;

/**
 * Created by sailesh on 2/2/22.
 */
public class StudentRecord {

    @CsvBindByName(required = true)
    private String name;

    @CsvBindByName(required = true)
    private String address;

    @CsvBindByName(required = true)
    private Integer age;

    @CsvBindByName(required = true)
    private String gender;

    @CsvDate(value = "yyyy-MM-dd")
    @CsvBindByName(required = true)
    private Date dob;

    @CsvBindByName(required = false)
    private String fatherName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }
}
