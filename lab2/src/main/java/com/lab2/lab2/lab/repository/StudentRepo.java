package com.lab2.lab2.lab.repository;

import com.lab2.lab2.lab.entity.Course;
import com.lab2.lab2.lab.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepo {
    private static List<Student> students = new ArrayList<>();
    static {
        students.add(new Student(1, "Eegii", "Unur", "eegii@miu.edu", "WAP", new ArrayList<Course>()));
        students.add(new Student(2, "Dan", "Sam", "dan@miu.edu", "Big Data", new ArrayList<Course>()));
        students.add(new Student(3, "John", "Doe", "john@miu.edu", "Algorithm", new ArrayList<Course>()));
    }
    public void save(Student student){
        students.add(student);
    };

    public List<Student> getAll(){
        return students;
    };

    public Student getById(int id) {
        return students.stream()
                .filter(s->s.getId()==id)
                .findFirst()
                .get();
    }
    public Student post(Student student) {
        students.add(student);
        return student;
    };

    public void update(int id, Student student){
        students.stream()
                .filter(s->s.getId()==id)
                .findFirst()
                .ifPresent(s->{
                    if(student.getFirstName() !=null)
                        s.setFirstName(student.getFirstName());
                    if (student.getLastName() != null)
                        s.setLastName(student.getLastName());
                    if (student.getEmail() != null)
                        s.setEmail(student.getEmail());
                    if (student.getMajor() != null)
                        s.setMajor(student.getMajor());
                });
    };

    public void delete(int id) {
        students.removeIf(s -> s.getId() == id);
    };

    public List<Student> getStudentsByMajor(String major) {
        return students.stream()
                .filter(s -> s.getMajor().equals(major))
                .collect(Collectors.toList());
    };

    public List<Course> getCoursesByStudentId(int studentId) {
        return students.stream()
                .filter(s -> s.getId() == studentId)
                .findFirst().get().getCoursesTaken();
    };


};
