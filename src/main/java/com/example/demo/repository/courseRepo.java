package com.example.demo.repository;


import com.example.demo.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class courseRepo {

    private static List<Course> courseList = new ArrayList<>();
    public void save(Course course){
        courseList.add(course);
    }

    public static List<Course> getAll() {
        return courseList;
    }

    public boolean delete(Course course) {
        return courseList.remove(course);
    }

}
