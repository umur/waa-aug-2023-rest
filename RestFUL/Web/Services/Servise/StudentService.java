package com.example.Lab2.RestFUL.Web.Services.Servise;

import com.example.Lab2.RestFUL.Web.Services.entity.Course;
import com.example.Lab2.RestFUL.Web.Services.entity.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);
    Student getStudentById(Long id);
    List<Student> getAllStudents();
    void deleteStudentById(Long id);
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(Long studentId);
}
