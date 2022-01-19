package com.javaWithSpringCourse.smsBoot.repository;

import com.javaWithSpringCourse.smsBoot.entity.Student;
import com.javaWithSpringCourse.smsBoot.utils.FileUtil;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sailesh on 1/4/22.
 */
@Repository
public class FileStudentRepository implements StudentRepository {

    private static final String FILE_NAME = "/files/students.txt";

    public Student saveStudent(Student student) {
        Integer key = FileUtil.getLastUniqueIdentifier(FILE_NAME);
        student.setId(key + 1);
        String record = student.toCsvString();
        String savedString = FileUtil.saveRecordsToFile(FILE_NAME, record);
        List<Student> students = toStudentObject(savedString);

        return students.get(0);
    }



    public Student findStudent(Integer studentId) {
        String record = FileUtil.getRecordByKey(FILE_NAME, studentId);
        List<Student> students = toStudentObject(record);
        return  (students.isEmpty()) ? null : students.get(0);

    }

    @Override
    public List<Student> findStudent(String studentName) {

        String record = FileUtil.getRecordByName(FILE_NAME, studentName);
        List<Student> students = toStudentObject(record);
        return  students;
    }

    public List<Student> findAllStudent(){
        String records = FileUtil.getRecords(FILE_NAME);
        return toStudentObject(records);
    }

    @Override
    public Student updateStudent(Student student) {

        List<Student> students = findAllStudent();
        StringBuilder stringBuilder = new StringBuilder();

        for(Student student1 : students) {
            if(student1.getId() == student.getId()) {
                stringBuilder.append(student.toCsvString());
            } else {
                stringBuilder.append(student1.toCsvString());
            }
            stringBuilder.append(System.lineSeparator());
        }

        FileUtil.overrideRecordsToFile(FILE_NAME, stringBuilder.toString());

        return student;
    }

    @Override
    public Student deleteStudent(Student student) {
        List<Student> students = findAllStudent();
        StringBuilder stringBuilder = new StringBuilder();
        for(Student student1 : students) {
            if(student1.getId() != student.getId()) {
                stringBuilder.append(student1.toCsvString());
                stringBuilder.append(System.lineSeparator());
            }

        }




        FileUtil.overrideRecordsToFile(FILE_NAME, stringBuilder.toString());

        return student;
    }


    private List<Student> toStudentObject(String record) {
        List<Student> students = new ArrayList<>();
        if(record != null && !record.isEmpty()){
            String[] rows = record.split("\n");
            for(String row : rows) {
                String[] fields = row.split(",");
                Student student = new Student();

                try{
                    student.setId(Integer.parseInt(fields[0]));
                } catch (NumberFormatException e) {
                    //do nothing
                }
                student.setName(fields[1]);
                student.setAge(Integer.parseInt(fields[2]));
                student.setAddress(fields[3]);
                student.setGender(fields[4]);
                try{
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
                    student.setDob(sdf.parse(fields[5]));
                } catch (ParseException e) {
                    System.out.println("Error parsing the date");
                }

                students.add(student);
            }
        }

        return students;

    }


}


// number of methods or behaviour
// signature of methods(method name, parmas, type of params, return type)
//studentId,studentName
