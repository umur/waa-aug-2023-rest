package com.example.assignment2.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    int id;
    String firstName;
    String lastName;
    String email;
    String major;
    List<Course> courseTaken;

}
