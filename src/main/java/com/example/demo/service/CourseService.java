package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import com.example.demo.entity.Course;

import java.util.List;

public interface CourseService {
    void save(CourseDto course);

    public List<CourseDto> getAll();
    CourseDto getById(int id);
    void update(CourseDto courseDto, int id);

    void delete(int id);
}
