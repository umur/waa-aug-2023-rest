package com.lab2.lab2.lab.service.Impl;

import com.lab2.lab2.lab.entity.Course;
import com.lab2.lab2.lab.repository.CourseRepo;
import com.lab2.lab2.lab.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {
    private final CourseRepo courseRepo;

    @Override
    public void save(Course c) {
        courseRepo.save(c);

    };

    @Override
    public Course getByID(int id) {
        return courseRepo.getByID(id);
    };

    @Override
    public List<Course> getAll() {
        return courseRepo.getAll();
    };

    @Override
    public void update(int id, Course course) {
        courseRepo.update(id, course);
    };

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    };
};
