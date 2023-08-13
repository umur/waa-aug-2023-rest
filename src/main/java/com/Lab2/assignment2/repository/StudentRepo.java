package com.Lab2.assignment2.repository;

import com.Lab2.assignment2.entity.Course;
import com.Lab2.assignment2.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository

public class StudentRepo {

    private static List<Student> students = new ArrayList<>();

    public void save(Student student) {
        students.add(student);
    }

    public List<Student> getAll() {
        return students;
    }

    public Optional<Student> getById(int id) {

//        for (Student student : students){
//            if (student.getId() == id) return student;
//        }
        Optional<Student> student = students.stream().filter(f -> f.getId() == id).findFirst();
        return student;
    }

    public void update(Student newStudent, int id) {

        Optional<Student> studentOptional = getById(id);

        if (studentOptional.isPresent()) {

            Student student = studentOptional.get();

            student.setEmail(newStudent.getEmail());
            student.setCoursesTaken(newStudent.getCoursesTaken());
            student.setId(newStudent.getId());
            student.setLastName(newStudent.getLastName());
            student.setFirstName(newStudent.getFirstName());
            student.setMajor(newStudent.getMajor());

        }
    }

    public void delete(int id) {
        Optional <Student> studentToDelete = getById(id);

        if (studentToDelete.isPresent()){

            students.remove(studentToDelete.get());
        }
    }

    public List<Course> getCoursesByStudentId(int id) {

//        List<Course> courses = students.stream()
//                .filter(student -> student.getId() == id)
//                .map(student -> student.getCoursesTaken())
//                .flatMap(List::stream)
//                .toList();
//        return courses;

        Optional<Student> studentOptional = getById(id);
        if(studentOptional.isPresent()){
            return studentOptional.get().getCoursesTaken();
        }else{
            return new ArrayList<>();
        }
    }

    public List<Student> getStudentsByMajor(String major) {
        return students.stream()
                .filter(student -> student.getMajor().equals(major))
                .toList();
    }
}
