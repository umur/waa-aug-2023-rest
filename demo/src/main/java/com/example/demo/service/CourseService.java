package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;

import java.util.List;

public interface CourseService {
     void saveCourse(CourseDto courseDto);
     List<CourseDto> getAllCourses();
     List<CourseDto> getCoursesByStudentId(int StudentId);

}
