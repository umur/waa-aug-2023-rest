package com.example.demo.repository;

import com.example.demo.entitiy.Course;
import com.example.demo.entitiy.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepo {
    private static List<Course> courses  = new ArrayList<>();

    public Course save(Course course){
        courses.add(course);
        return course;
    }

    public Course update(Course course, int id){
        var specificCourse = courses.stream()
                .filter(data -> data.getId() == id)
                .findFirst();
        if(specificCourse.isPresent()){
            var courseToUpdate = specificCourse.get();
            courseToUpdate.setCode(course.getCode());
            courseToUpdate.setName((course.getCode()));
            return courseToUpdate;
        }
        return null;
    }

    public void delete(int id){
        Optional<Course> specificCourse = courses.stream()
                .filter(data -> data.getId() == id)
                .findFirst();

        specificCourse.ifPresent(course -> courses.remove(course));
    }

    public Course findById(int id){
       return  courses.stream()
                .filter(data -> data.getId() == id)
                .findFirst()
                .get();

    }
    public List<Course> getAll(){
        return courses;
    }
}
