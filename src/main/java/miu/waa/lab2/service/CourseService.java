package miu.waa.lab2.service;

import miu.waa.lab2.dto.CourseDto;

import java.util.Map;

public interface CourseService {
    Map<Integer, CourseDto> getAll();
    void  create(CourseDto course);
    CourseDto read (int id);
    void update(CourseDto course);
    void delete(int id);
}
