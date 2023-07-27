package com.example.assignment2.Repositories;

import com.example.assignment2.Entities.Course;
import com.example.assignment2.Entities.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class StudentRepository {
    private static List<Student> students = new ArrayList<>();

    public void save(Student student) {
        students.add(student);
    }
    public List<Student> getAll(){
        return students;
    }
    public Student getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    public void update(Student student, int id) {
        for(Student st: students){
            if(st.getId() == id){
                st.setId(student.getId());
                st.setEmail(student.getEmail());
                st.setMajor(student.getMajor());
                st.setFirstName(student.getFirstName());
                st.setLastName(student.getLastName());
                st.setCoursesTaken(student.getCoursesTaken());
                return;
            }
        }
    }

    public void deleteById(int id) {
        // Use an iterator to safely remove the student while iterating over the list
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student st = iterator.next();
            if (st.getId() == id) {
                iterator.remove();
                return;
            }
        }
    }

    public List<Student> getStudentByMajor(String major) {
        List<Student> studentsByMajor = new ArrayList<>();
        for(Student st: students){
            if(st.getMajor().equals(major)){
                studentsByMajor.add(st);
            }
        }
        return studentsByMajor;
    }

    public List<Course> getCoursesByStudentId(int id) {
        for(Student st: students){
            if(st.getId() == id){
                return st.getCoursesTaken();
            }
        }
        return null;
    }
}
