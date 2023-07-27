package com.example.assignment2.repository;

import com.example.assignment2.dto.CourseDto;
import com.example.assignment2.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    private static List<Course> courses = new ArrayList<>();

    static{
        courses.add(new Course(1, "Course1", "CO1"));
        courses.add(new Course(2, "Course2", "CO2"));
        courses.add(new Course(3, "Course3", "CO3"));
        courses.add(new Course(4, "Course4", "CO4"));
        courses.add(new Course(5, "Course5", "CO5"));
    }

    public void save(Course course){
        courses.add(course);
    }

    public List<Course> getAll(){
        return courses;
    }

    public void remove(int id) {
        courses.removeIf(course -> course.getId()==id);
    }

    public void update(CourseDto courseDto, int id) {
        courses.forEach(course -> {
            if(course.getId()==id){
                course.setName(courseDto.getName());
                course.setCode(courseDto.getCode());
            }
        });

    }
}
