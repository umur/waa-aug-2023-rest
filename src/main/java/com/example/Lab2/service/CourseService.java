package com.example.Lab2.service;

import com.example.Lab2.entity.Course;

import java.util.List;

public interface CourseService {
    void addCourse(Course course);
    List<Course> getAllCourses();
    Course getCourseById(int courseId);
    void updateCourse(Course updatedCourse,int courseId);
    void deleteCourse(int courseId);
}
