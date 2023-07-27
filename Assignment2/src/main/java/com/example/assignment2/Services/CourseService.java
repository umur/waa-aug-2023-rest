package com.example.assignment2.Services;

import com.example.assignment2.Entities.Course;
import com.example.assignment2.Entities.Student;
import com.example.assignment2.Repositories.CourseRepository;
import com.example.assignment2.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getAll() {
        return courseRepository.getAll();
    }

    public void save(Course course) {
        courseRepository.save(course);
    }

    public void update(Course course, int id) {
        courseRepository.update(course, id);
    }
    public Course getCourseById(int id){
        return courseRepository.getCourseById(id);
    }

    public void deleteById(int id) {
        courseRepository.deleteById(id);
    }

}
