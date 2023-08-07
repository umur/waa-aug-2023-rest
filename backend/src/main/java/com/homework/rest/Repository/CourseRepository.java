package com.homework.rest.Repository;

import com.homework.rest.Dto.CourseDto;
import com.homework.rest.Entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class CourseRepository {

    private static List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void removeCourse(String id) {
        Iterator<Course> iterator = courses.iterator();
        while (iterator.hasNext()) {
            Course course = iterator.next();
            if(id.equals(course.getId())) {
                iterator.remove();
            }
        }
    }

    public void updateCourse(String id,Course updateCourse) {
        Iterator<Course> iterator = courses.iterator();
        while (iterator.hasNext()) {
            Course course = iterator.next();
            if(id.equals(course.getId())) {
                course.setId(updateCourse.getId());
                course.setName(updateCourse.getName());
                course.setCode(updateCourse.getCode());
            }
        }
    }
}
