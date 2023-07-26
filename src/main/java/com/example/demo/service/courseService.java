package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Student;

import java.util.List;

public interface courseService {

    public void save(Course course);
    public List<Course> getAll();
    public boolean delete(Course course);

}
