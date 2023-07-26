package lab2.service;

import lab2.dto.StudentDto;
import lab2.model.Course;

import org.springframework.stereotype.Service;

import java.util.List;
//@Service
public interface courseService {

    Course getCourseById(int id);
    List<Course> getAllCourses();
    void saveCourse(Course course);
    void updateCourse(Course course);
    void deleteCourseById(int id);




}
