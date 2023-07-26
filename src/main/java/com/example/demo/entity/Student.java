package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Student {

    private int id;
    private String firstName, lastName, email, major;
    private List<Course> coursesTaken;
}
