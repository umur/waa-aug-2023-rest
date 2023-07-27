package com.homework.rest;

import com.homework.rest.Entity.Course;
import com.homework.rest.Repository.CourseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication {

    public static void main(String[] args) {
        Course course = new Course("001","Math","CS244");
        Course course1 = new Course("002","EA","CS234");
        Course course3 = new Course("003","Science","CS235");
        CourseRepository courseRepository = new CourseRepository();
        courseRepository.addCourse(course);
        courseRepository.addCourse(course1);
        courseRepository.addCourse(course3);

        SpringApplication.run(RestApplication.class, args);
    }

}
