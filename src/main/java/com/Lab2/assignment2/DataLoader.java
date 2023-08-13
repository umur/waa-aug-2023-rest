package com.Lab2.assignment2;

import com.Lab2.assignment2.entity.Course;
import com.Lab2.assignment2.entity.Student;
import com.Lab2.assignment2.repository.CourseRepo;
import com.Lab2.assignment2.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private CourseRepo courseRepo;
    private StudentRepo studentRepo;

    @Autowired
    public DataLoader(CourseRepo courseRepo, StudentRepo studentRepo) {
        this.courseRepo = courseRepo;
        this.studentRepo = studentRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        var course = new Course(1, "SWE", "SWE");
        var course2 = new Course(2, "WAA", "WAA");

        var student = new Student(1, "John", "Doe", "jdoe@gmail.com", "CS", List.of(course, course2));

        courseRepo.save(course);
        courseRepo.save(course2);
        studentRepo.save(student);

    }
}
