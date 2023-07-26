package com.example.demo.entitiy;

import com.example.demo.dto.CourseDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<CourseDto> courseTaken;
}
