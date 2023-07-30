package com.example.Assignment2.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Student {
    private int id;
    private String firstName;

    private String lastName;

    private String email;

    private String major;

    private List<Student> courseTaken;



}
