package com.example.Lab2.RestFUL.Web.Services.Servise;

import com.example.Lab2.RestFUL.Web.Services.Repository.CourseRepository;
import com.example.Lab2.RestFUL.Web.Services.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImpl implements  CourseService{
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteById(id);

    }
}
