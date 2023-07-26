package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CourseService {
    CourseDto save(CourseDto course);

    CourseDto update(CourseDto course, int id);

    void delete(int id);

    CourseDto getById(int id);
    List<CourseDto> getAll();
}
