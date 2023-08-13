package com.Lab2.assignment2.dto;

import com.Lab2.assignment2.entity.Course;
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
    private List<Course> courses;
}
