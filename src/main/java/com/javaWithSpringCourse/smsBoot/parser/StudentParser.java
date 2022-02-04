package com.javaWithSpringCourse.smsBoot.parser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaWithSpringCourse.smsBoot.entity.Student;
import com.javaWithSpringCourse.smsBoot.model.StudentDto;
import com.javaWithSpringCourse.smsBoot.model.StudentRecord;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sailesh on 2/2/22.
 */
@Service
public class StudentParser extends  AbstractCsvParser<StudentRecord> {

    @Override
    public Class getEntity() {
        return StudentRecord.class;
    }

    @Override
    public Character getDelimiter() {
        return ',';
    }

    public List<Student> parseAndMapStudents(MultipartFile file) throws  Exception {
        List<StudentRecord> studentRecords = parse(file);
        List<Student> students = new ArrayList<>();
        for(StudentRecord studentRecord : studentRecords) {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Student student = objectMapper.convertValue(studentRecord, Student.class);
            students.add(student);
       }
       return students;
    }


}
