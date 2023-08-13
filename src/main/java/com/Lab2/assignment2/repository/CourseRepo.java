package com.Lab2.assignment2.repository;

import com.Lab2.assignment2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CourseRepo {

    private static List<Course> courses = new ArrayList<>();

    public void save(Course course) {
        courses.add(course);
    }

    public List<Course> getAll() {
        return Collections.unmodifiableList(courses);
    }

    public Optional<Course> getById(int id) {

//        for (Course course: courses){
//            if (course.getId() == id) return course;
//        }

        Optional<Course> course = courses.stream().filter(f -> f.getId() == id).findFirst();
        return course;
    }

    public void update(Course newCourse, int id) {

        Optional<Course> courseOpt = getById(id);

        if (courseOpt.isPresent()) {
            Course course = courseOpt.get();

            course.setCode(newCourse.getCode());
            course.setName(newCourse.getName());
        }
    }

    public void delete(int id) {

        Optional<Course> courseToDelete = getById(id);

        if (courseToDelete.isPresent()) {

            courses.remove(courseToDelete.get());
        }
    }
}
