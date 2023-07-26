package com.example.demo.service.impl;

import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepo;
import com.example.demo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImplementation implements CourseService {
    private final CourseRepo courseRepo;

    @Override
    public Course save(Course course) {
        courseRepo.save(course);
        return course;
    }

    @Override
    public Course getCourseById(int id) {
        return courseRepo.getCourseById(id);
    }

    @Override
    public List<Course> getCourses() {
        return courseRepo.getCourses();
    }

    @Override
    public void deleteCourseById(int id) {
        courseRepo.deleteCourseById(id);
    }

    @Override
    public Course updateCourse(int id, Course course) {
        Course oldCourse = courseRepo.getCourseById(id);
        if (oldCourse != null) {
            oldCourse.setName(course.getName());
            oldCourse.setCode(course.getCode());
            return courseRepo.save(oldCourse);
        }
        return oldCourse;
    }
}
