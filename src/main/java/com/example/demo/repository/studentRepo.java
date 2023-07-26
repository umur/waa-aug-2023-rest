package com.example.demo.repository;

import com.example.demo.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class studentRepo {

    private static List<Student> studentList = new ArrayList<>();

    public void save (Student student){
        studentList.add(student);
    }

    public List<Student> getAll(){
        return studentList;
    }

    public boolean delete(Student student){
       return studentList.remove(student);
    }


}
