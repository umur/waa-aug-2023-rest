package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private static List<Course> courses = new ArrayList<>();

    public void saveCourse(Course course){
        courses.add(course);
    }

    public List<Course> getAllCourses(){

        return courses;
    }
}
