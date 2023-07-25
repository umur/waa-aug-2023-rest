package com.lab2.lab2.lab.service;

import com.lab2.lab2.lab.entity.Course;
import com.lab2.lab2.lab.entity.Student;

import java.util.List;

public interface CourseService {
    void save(Course c);
    Course getByID(int id);
    List<Course> getAll();
    void update(int id, Course course);
    void delete(int id);
}
