package com.Lab2ResfulWeb.lab2.DTO;

import com.Lab2ResfulWeb.lab2.Entiry.Course;

import java.util.List;

public class StudentDTO  {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private String coursesTaken;


    private List<Course> courselist;
}
