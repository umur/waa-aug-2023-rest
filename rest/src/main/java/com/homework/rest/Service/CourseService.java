package com.homework.rest.Service;

import com.homework.rest.Dto.CourseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CourseService {
    List<CourseDto> getCourse();
    void addCourse(CourseDto dto);
    void removeCourse(String id);
    void updateCourse(String id,CourseDto dto);
}
