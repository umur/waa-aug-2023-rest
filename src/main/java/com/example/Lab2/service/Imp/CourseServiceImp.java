package com.example.Lab2.service.Imp;

import com.example.Lab2.entity.Course;
import com.example.Lab2.repository.CourseRepo;
import com.example.Lab2.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImp implements CourseService {
    @Autowired
    private CourseRepo courseRepo;

    // Add a new course
    public void addCourse(Course course) {
        courseRepo.addCourse(course);
    }

    // Get all courses
    public List<Course> getAllCourses() {
        return courseRepo.getAllCourses();
    }

    // Get a course by ID
    public Course getCourseById(int courseId) {
        return courseRepo.getCourseById(courseId);
    }

    // Update an existing course
    public void updateCourse(Course updatedCourse,int id) {
        courseRepo.updateCourse(updatedCourse,id);
    }

    // Delete a course by ID
    public void deleteCourse(int courseId) {
        courseRepo.deleteCourse(courseId);
    }
}

