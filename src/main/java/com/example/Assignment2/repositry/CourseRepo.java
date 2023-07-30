package com.example.Assignment2.repositry;

import com.example.Assignment2.dto.CourseDto;
import com.example.Assignment2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepo {
    List<Course> courseList = new ArrayList<>();

    public void save(Course course){
        courseList.add(course);
    }

    public List<Course> getAll() {
        return courseList;
    }

    public void update(){

    }

    public Optional<Course> findById(int id) {
        return courseList.stream()
                .filter(course -> course.getId()==id)
                .findFirst();
    }

    public void delete(int id) {
        courseList.removeIf(course->course.getId()==id);

    }
}
