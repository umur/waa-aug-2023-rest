package com.example.Assignment2.service;

import com.example.Assignment2.dto.CourseDto;
import com.example.Assignment2.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public interface CourseService {

     void save(CourseDto course);
     List<CourseDto> getAll();


     void update(Course course);

     void delete(int id);

     Optional<Course> getCourseById(int id);
}
