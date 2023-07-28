package com.example.Lab2.service;

import com.example.Lab2.entity.Course;
import com.example.Lab2.entity.Student;

import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(int studentId);
    void updateStudent(Student updatedStudent, int id);
    void deleteStudent(int studentId);
    List<Student> getStudentsByMajor(String major);
    List<Course> getCoursesByStudentId(int studentId);
}
