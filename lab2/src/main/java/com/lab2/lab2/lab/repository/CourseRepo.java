package com.lab2.lab2.lab.repository;

import com.lab2.lab2.lab.dto.CourseDto;
import com.lab2.lab2.lab.entity.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepo {
    private  static List<Course> courses = new ArrayList<>();
    static{
        courses.add(new Course(1,"Java Fundamentals","CS545"));
        courses.add(new Course(2,"Advance Java","CS572"));
        courses.add(new Course(3,"Spring Boot, Hibernate and React","CS501"));

    }

    public void save(Course course){
        courses.add(course);
    };

    public List<Course> getAll(){
        return courses;
    };


    public Course getByID(int id){
        return courses.stream()
                .filter(c->c.getId()==id)
                .findFirst().get();
    };

    public void update(int id, Course course){
        courses.stream().filter(c->c.getId()==id)
                .findFirst()
                .ifPresent(c->{
                    if(course.getName()!=null)c.setName(course.getName());
                    if(course.getCode()!=null)c.setCode(course.getCode());
                });
    }
    public void delete(int id){
        courses.removeIf(c->c.getId()==id);
    }



};
