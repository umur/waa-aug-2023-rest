package com.example.assignment2.service;

import com.example.assignment2.dto.CourseDto;

import java.util.List;

public interface CourseService {
    void save(CourseDto course);
    List<CourseDto> getAll();

    void remove(int id);

    void update(CourseDto course, int id);

}
