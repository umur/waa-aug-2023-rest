package com.homework.rest.Service;

import com.homework.rest.Dto.CourseDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> getCourses();
    void addCourse(CourseDto dto);
    void removeCourse(String id);
    void updateCourse(String id,CourseDto dto);
}
