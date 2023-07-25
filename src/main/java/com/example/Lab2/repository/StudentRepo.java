package com.example.Lab2.repository;

import com.example.Lab2.entity.Course;
import com.example.Lab2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {
    List<Student> students = new ArrayList<>();
    // Create (Add) a new student
    public void addStudent(Student student) {
        students.add(student);
    }

    // Read (Get) all students
    public List<Student> getAllStudents() {
        return students;
    }

    // Read (Get) a student by ID
    public Student getStudentById(int studentId) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null; // Student with the specified ID not found
    }

    // Update an existing student
    public void updateStudent(Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId() == updatedStudent.getId()) {
                students.set(i, updatedStudent);
                break;
            }
        }
    }

    // Delete a student by ID
    public void deleteStudent(int studentId) {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getId() == studentId) {
                students.remove(i);
                break;
            }
        }
    }
    public List<Student> getStudentsByMajor(String major){
        return students.stream().filter(std->std.getMajor() == "major").toList();
    }
    public List<Course> getCoursesByStudentId(int studentId){
        List<Course> coursesByStudentId = new ArrayList<>();
        Student student = getStudentById(studentId);
        if (student != null) {
            coursesByStudentId = student.getCourses();
        }

        return coursesByStudentId;
    }

}
