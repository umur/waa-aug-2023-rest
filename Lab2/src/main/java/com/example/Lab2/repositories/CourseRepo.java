package com.example.Lab2.repositories;

import com.example.Lab2.entities.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {

    private List<Course> courses;

    public CourseRepo() {
        courses= new ArrayList<>();
    }

    public List<Course> getAll() {
        return courses;
    }

    public Course getById(int id) {
        return courses.stream()
                .filter(course -> course.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void create(Course course) {
        courses.add(course);
    }

    public void update(Course course) {
        Course courseToUpdate= getById(course.getId());
        if (courseToUpdate != null) {
            courseToUpdate.setName(course.getName());
            courseToUpdate.setCode(course.getCode());
        }
    }

    public void deleteById(int id) {
        Course courseToDelete= getById(id);
        courses.remove(courseToDelete);
    }
}
