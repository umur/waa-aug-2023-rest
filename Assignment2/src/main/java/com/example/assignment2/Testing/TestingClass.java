/*
package com.example.assignment2.Testing;

import com.example.assignment2.Entities.Course;
import com.example.assignment2.Entities.Student;
import com.example.assignment2.Repositories.CourseRepository;
import com.example.assignment2.Repositories.StudentRepository;

import java.util.List;

public class TestingClass {
    public static void testCase(){
        CourseRepository courseRepository = new CourseRepository();
        StudentRepository studentRepository = new StudentRepository();

        // Creating and adding some courses
        Course course1 = new Course(1, "Mathematics", "MATH101");
        Course course2 = new Course(2, "Physics", "PHY101");
        courseRepository.save(course1);
        courseRepository.save(course2);

        // Creating and adding some students with courses taken
        Student student1 = new Student(1, "John", "Doe", "john@example.com", "Computer Science");
        student1.getCoursesTaken().add(course1);
        Student student2 = new Student(2, "Jane", "Smith", "jane@example.com", "Physics");
        student2.getCoursesTaken().add(course1);
        student2.getCoursesTaken().add(course2);
        studentRepository.save(student1);
        studentRepository.save(student2);

        // Get all students majoring in "Physics"
        List<Student> physicsStudents = studentRepository.getStudentByMajor("Physics");
        System.out.println("Students majoring in Physics:");
        for (Student student : physicsStudents) {
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }

        // Get all courses taken by student with ID = 2
        List<Course> coursesTakenByStudent2 = studentRepository.getCoursesByStudentId(2);
        System.out.println("\nCourses taken by Student 2:");
        for (Course course : coursesTakenByStudent2) {
            System.out.println(course.getName());
        }
    }
}
*/
