package com.example.demo.repository;

import com.example.demo.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    private final List<Course> courses = new ArrayList<>();

    public Course save(Course course) {
        courses.add(course);
        return course;
    }

    public Course getCourseById(int id) {
        return courses.stream().filter(
                course -> course.getId() == id
        ).findFirst().orElse(null);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void deleteCourseById(int id) {
        System.out.println("IDDD" + id);
        courses.removeIf(course ->
                course.getId() == id
        );
    }
}
