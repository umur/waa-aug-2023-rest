package com.example.Assignment2.dto;

import com.example.Assignment2.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class StudentDto {
    private int id;
    private String firstName;

    private String lastName;

    private String email;

    private String major;

    private List<Student> courseTaken;
}
