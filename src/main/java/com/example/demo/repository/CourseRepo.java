package com.example.demo.repository;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepo {
    private static List<Course> courses = new ArrayList<>();

    public void save (Course course){
        courses.add(course);
    }

    public List<Course> getAll(){
        return courses;
    }

    public void update(Course course, int id) {
        courses = courses.stream().map(cour -> cour.getId() == id? course: cour).collect(Collectors.toList());
    }

    public void delete(int id) {
        courses = courses.stream().filter(cour -> cour.getId() != id).collect(Collectors.toList());
    }
}
