package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;

import java.util.List;

public interface studentService {

    public void save(Student student);
    public List<Student> getAll();
    public boolean delete(Student student);
    public List<Student> getAllStudentsByMajor(String major);
    public List<Course> getStudentCoursesByStudentId(int id);
}
