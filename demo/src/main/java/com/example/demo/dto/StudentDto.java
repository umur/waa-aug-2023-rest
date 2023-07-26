package com.example.demo.dto;

import com.example.demo.entity.Course;
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
        private List<Course> coursesTaken;

}
