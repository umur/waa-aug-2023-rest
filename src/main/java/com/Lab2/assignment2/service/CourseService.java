package com.Lab2.assignment2.service;

import com.Lab2.assignment2.dto.CourseDto;
import com.Lab2.assignment2.entity.Course;

import java.util.List;

public interface CourseService {

   void save(Course course);

   void update(Course course, int id);

   void delete(int id);

   List<Course> getAll();

   Course getById(int id);



}
