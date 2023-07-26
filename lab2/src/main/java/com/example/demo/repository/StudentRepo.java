package com.example.demo.repository;

import com.example.demo.entitiy.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentRepo {

    private static List<Student> students  = new ArrayList<>();

    public Student save(Student student){
        students.add(student);
        return student;
    }

    public Student update(Student student, int id){
        var specificStudent  = students.stream().filter(data -> data.getId() == id).findFirst();
        if(specificStudent.isPresent()){
            var studentToBeUpdated = specificStudent.get();
            studentToBeUpdated.setMajor(student.getMajor());
            studentToBeUpdated.setEmail(student.getEmail());
            studentToBeUpdated.setLastName(student.getLastName());
            studentToBeUpdated.setFirstName(student.getFirstName());
            studentToBeUpdated.setCourseTaken(student.getCourseTaken());
        }
        return student;
    }

    public void delete(int id){
        var specificStudent  = students.stream().filter(data -> data.getId() == id).findFirst();
        specificStudent.ifPresent(student -> students.remove(student));

    }


    public Student getById(int id){
        return students.stream().filter(data -> data.getId() == id).findFirst().get();
    }

    public List<Student> getAll(){
        return students;
    }

    public List<Student> getStudentsByMajor(String major) {
        List<Student> studentsByMajor = new ArrayList<>();
        for(Student student:students){
            if(student.getMajor().equalsIgnoreCase(major)){
                studentsByMajor.add(student);
            }
        }

        return studentsByMajor;

    }


}
