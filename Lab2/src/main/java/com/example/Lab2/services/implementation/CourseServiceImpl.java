package com.example.Lab2.services.implementation;

import com.example.Lab2.dto.CourseDto;
import com.example.Lab2.entities.Course;
import com.example.Lab2.repositories.CourseRepo;
import com.example.Lab2.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private CourseRepo courseRepo;

    @Autowired
    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public List<CourseDto> getAll() {
        List<Course> courses= courseRepo.getAll();
        List<CourseDto> courseDtos= new ArrayList<>();

        courses.forEach(course -> {
            CourseDto courseDto= new CourseDto();
            courseDto.setName(course.getName());
            courseDto.setCode(course.getCode());
            courseDtos.add(courseDto);
        });

        return courseDtos;
    }

    @Override
    public CourseDto getById(int id) {
        Course course= courseRepo.getById(id);
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        courseDto.setCode(courseDto.getCode());
        return courseDto;
    }

    @Override
    public void create(CourseDto courseDto) {
        Course course= new Course();
        course.setId(courseDto.getId());
        course.setName(courseDto.getName());
        course.setCode(courseDto.getCode());
        courseRepo.create(course);
    }

    @Override
    public void update(CourseDto courseDto) {
        Course course= courseRepo.getById(courseDto.getId());
        course.setCode(courseDto.getCode());
        course.setName(courseDto.getName());
        courseRepo.update(course);
    }

    @Override
    public void deleteById(int id) {
        courseRepo.deleteById(id);
    }
}
