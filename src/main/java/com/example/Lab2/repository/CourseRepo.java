package com.example.Lab2.repository;

import com.example.Lab2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CourseRepo {
    List<Course> courses = new ArrayList<>();
    public void addCourse(Course course){
        courses.add(course);
    }
    public List<Course> getAllCourses(){
        return courses;
    }
    public Course getCourseById(int courseId) {
        for (Course course : courses) {
            if (course.getId() == courseId) {
                return course;
            }
        }
        return null;
    }
    public void updateCourse(Course updatedCourse) {
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            if (course.getId() == updatedCourse.getId()) {
                courses.set(i, updatedCourse);
                break;
            }
        }
    }

    public void deleteCourse(int courseId) {
        for (int i = 0; i < courses.size(); i++) {
            Course course = courses.get(i);
            if (course.getId() == courseId) {
                courses.remove(i);
                break;
            }
        }
    }


}
