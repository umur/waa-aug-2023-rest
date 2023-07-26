package com.Tsinat.lab2restfullwebservice.backend.repository;

import com.Tsinat.lab2restfullwebservice.backend.entity.Course;
import com.Tsinat.lab2restfullwebservice.backend.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentsRepo {

private List<Student> studentList=new ArrayList<>();

public List <Student> getAll(){
    return studentList;
}

public void save (Student student) {
    studentList.add (student);


}
public void delete(int id){
    studentList.forEach((s)->{
        if(s.getId()==id)studentList.remove(s);
    });
}
public void update (int id,Student student){
    studentList.forEach((s)->{
        if(s.getId()==id){
            s=student;
        }
    });
}
public List<Student>getStudentByMajor(String major){
    List<Student> studentsWithSameMajor =new ArrayList<>();
    studentList.forEach((s)->{
        if(s.getMajor().equals(major))studentsWithSameMajor.add(s);

            });
    return studentsWithSameMajor;


}
public List <Course>getCoursesByStudentId(int id){
    for(Student s :studentList) {
        if(s.getId()==id)return s.getCoursesTaken();

    }
    return null;
}

public Student getById(int id){
    for(Student s: studentList){
        if(s.getId()==id) return s;
    }
    return null;
}


}
