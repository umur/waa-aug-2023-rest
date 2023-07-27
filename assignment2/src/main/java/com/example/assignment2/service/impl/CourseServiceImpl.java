package com.example.assignment2.service.impl;

import com.example.assignment2.dto.CourseDto;
import com.example.assignment2.dto.StudentDto;
import com.example.assignment2.entity.Course;
import com.example.assignment2.repository.CourseRepo;
import com.example.assignment2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepo courseRepo;

    @Override
    public void save(CourseDto course) {
        System.out.println(course.getId());
        System.out.println(course.getCode());
        System.out.println(course.getName());
        Course entity = new Course();
        entity.setId(course.getId());
        entity.setCode(course.getCode());
        entity.setName(course.getName());

        courseRepo.save(entity);
    }

    @Override
    public List<CourseDto> getAll() {
        List<Course> courseList = courseRepo.getAll();
        List<CourseDto> courseDtoList = new ArrayList<>();
        courseList.forEach(course -> {
            CourseDto dto = new CourseDto(course.getId(), course.getName(), course.getCode());
            courseDtoList.add(dto);
        });

        return courseDtoList;
    }

    @Override
    public void remove(int id) {
        courseRepo.remove(id);
    }

    @Override
    public void update(CourseDto course, int id) {
        courseRepo.update(course, id);
    }
}
