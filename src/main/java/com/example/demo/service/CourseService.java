package com.example.demo.service;

import com.example.demo.entity.Course;

import java.util.List;

public interface CourseService {
    Course save(Course course);

    Course getCourseById(int id);

    List<Course> getCourses();

    void deleteCourseById(int id);

    Course updateCourse(int id, Course course);
}
