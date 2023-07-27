package com.example.Lab2.RestFUL.Web.Services.Repository;

import com.example.Lab2.RestFUL.Web.Services.entity.Course;
import com.example.Lab2.RestFUL.Web.Services.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class CourseRepository {
    private final Map<Long, Course> courses = new HashMap<>();
    private long courseId = 1;

    public Course save(Course course) {
        if (course.getId() == null) {

            course.setId(courseId++);
        }
        else
            courses.put(course.getId(), course);
        return course;
    }


    public Course findById(Long id) {
        return courses.get(id);
    }


    public List<Course> findAll() {
        return new ArrayList<>(courses.values());
    }


    public void deleteById(Long id) {
        courses.remove(id);
    }
}

