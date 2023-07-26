package com.example.Lab2.services;

import com.example.Lab2.dto.CourseDto;

import java.util.List;

public interface CourseService {

    List<CourseDto> getAll();

    CourseDto getById(int id);

    void create(CourseDto course);

    void update(CourseDto course);

    void deleteById(int id);
}
