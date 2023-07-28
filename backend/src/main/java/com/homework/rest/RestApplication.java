package com.homework.rest;

import com.homework.rest.Entity.Course;
import com.homework.rest.Entity.Student;
import com.homework.rest.Repository.CourseRepository;
import com.homework.rest.Repository.StudentRepository;
import com.homework.rest.config.CorsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

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

        String[] courseTaken = {"CS244", "CS234", "CS235"};
        Student student = new Student("123","John","Doe","john.doe@example.com","Computer Science",courseTaken);
        StudentRepository studentRepository = new StudentRepository();
        studentRepository.addStudent(student);

        CorsConfig cors = new CorsConfig();
        cors.getCorsConfiguration();

        SpringApplication.run(RestApplication.class, args);
    }

}
