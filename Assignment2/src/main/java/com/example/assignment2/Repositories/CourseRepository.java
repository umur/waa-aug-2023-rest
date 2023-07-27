package com.example.assignment2.Repositories;

import com.example.assignment2.Entities.Course;
import com.example.assignment2.Entities.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class CourseRepository {
    private static List<Course> courses = new ArrayList<>();

    public void save(Course course) {
        courses.add(course);
    }
    public List<Course> getAll(){
        return courses;
    }
    public void update(Course course, int id) {
        for(Course cr: courses){
            if(cr.getId() == id){
                cr.setId(course.getId());
                cr.setCode(course.getCode());
                cr.setName(course.getName());
                return;
            }
        }
    }
    public Course getCourseById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public void deleteById(int id) {
        Iterator<Course> iterator = courses.iterator();
        while (iterator.hasNext()) {
            Course cr = iterator.next();
            if (cr.getId() == id) {
                iterator.remove();
                return;
            }
        }
    }

}
