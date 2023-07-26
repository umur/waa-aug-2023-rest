package com.example.demo.service.impl;

import com.example.demo.dto.CourseDto;
import com.example.demo.entitiy.Course;
import com.example.demo.repository.CourseRepo;
import com.example.demo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {


    private CourseRepo courseRepo;
    @Override
    public CourseDto save(CourseDto course) {
       var entity = new Course();
       entity.setCode(course.getCode());
       entity.setName(course.getName());
       courseRepo.save(entity);
       return course;
    }


    @Override
    public CourseDto update(CourseDto course, int id) {
        Course courseToUpdate = courseRepo.findById(id);
        if (courseToUpdate != null) {
            courseToUpdate.setName(course.getName());
            courseToUpdate.setCode(course.getCode());
            Course updatedCourse = courseRepo.save(courseToUpdate);
            return mapToDto(updatedCourse);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }

    @Override
    public CourseDto getById(int id) {
        Course course = courseRepo.findById(id);
        if(course != null){
            return mapToDto(course);
        }
        return null;
    }


    @Override
    public List<CourseDto> getAll() {

        List<Course> allCourses = courseRepo.getAll();
        return allCourses.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private CourseDto mapToDto(Course course) {
        CourseDto courseDto = new CourseDto();
        courseDto.setName(course.getName());
        courseDto.setCode(course.getCode());
        return courseDto;
    }

}
