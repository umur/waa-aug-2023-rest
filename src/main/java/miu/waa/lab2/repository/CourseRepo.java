package miu.waa.lab2.repository;

import miu.waa.lab2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CourseRepo {
    Map<Integer, Course> courses = new HashMap<>();

    public Map<Integer, Course> getAll(){
        return courses;
    }

    public void create(Course course) {
        courses.putIfAbsent(course.getId(), course);
    }

    public Course read(int id){
        return courses.getOrDefault(id, new Course());
    }

    public void update(Course course){
        courses.put(course.getId(), course);
    }

    public void delete(int id){
        courses.remove(id);
    }
}
