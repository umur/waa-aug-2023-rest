package com.example.assignment2.dto;

import com.example.assignment2.entity.Course;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentDto {
    int id;
    String firstName;
    String lastName;
    String email;
    String major;
    List<Course> courseTaken;
}
