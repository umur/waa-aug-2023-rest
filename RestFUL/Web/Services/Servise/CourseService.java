package com.example.Lab2.RestFUL.Web.Services.Servise;

import com.example.Lab2.RestFUL.Web.Services.entity.Course;

import java.util.List;

public interface CourseService {
    Course saveCourse(Course course);
    Course getCourseById(Long id);
    List<Course> getAllCourses();
    void deleteCourseById(Long id);
}
