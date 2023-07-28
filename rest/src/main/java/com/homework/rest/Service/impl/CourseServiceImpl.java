package com.homework.rest.Service.impl;

import com.homework.rest.Dto.CourseDto;
import com.homework.rest.Dto.StudentDto;
import com.homework.rest.Entity.Course;
import com.homework.rest.Repository.CourseRepository;
import com.homework.rest.Service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public void addCourse(CourseDto dto) {
        Course course = new Course();
        course.setId(dto.getId());
        course.setName(dto.getName());
        course.setCode(dto.getCode());
        courseRepository.addCourse(course);
    }

    @Override
    public List<CourseDto> getCourses() {
        List<Course> entityList = courseRepository.getCourses();
        List<CourseDto> dtoList = new ArrayList<>();
        entityList.forEach(entity -> {
            var dto = new CourseDto();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setCode(entity.getCode());
            dtoList.add(dto);
        });
        return dtoList;
    }

    @Override
    public void updateCourse(String id,CourseDto dto) {
        var entity = new Course();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setCode(dto.getCode());
        courseRepository.updateCourse(id,entity);
    }

    @Override
    public void removeCourse(String id) {
        System.out.println(id);
        courseRepository.removeCourse(id);
    }
}
