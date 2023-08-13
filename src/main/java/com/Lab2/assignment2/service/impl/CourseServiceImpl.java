package com.Lab2.assignment2.service.impl;

import com.Lab2.assignment2.dto.CourseDto;
import com.Lab2.assignment2.entity.Course;
import com.Lab2.assignment2.repository.CourseRepo;
import com.Lab2.assignment2.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class CourseServiceImpl implements CourseService {

    private  CourseRepo courseRepo;

    @Autowired
    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public void save(Course course) {

        courseRepo.save(course);

    }

    @Override
    public void update(Course course, int id) {

        courseRepo.update(course, id);

    }

    @Override
    public void delete(int id) {

        courseRepo.delete(id);

    }

    @Override
    public List<Course> getAll() {

        return courseRepo.getAll();

    }

    @Override
    public Course getById(int id) {

        Optional<Course> courseOptional = courseRepo.getById(id);

        if(courseOptional.isPresent()){
            return courseOptional.get();
        }
        throw new RuntimeException("Course id not found");
    }
}
