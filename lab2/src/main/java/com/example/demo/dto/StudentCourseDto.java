package com.example.demo.dto;

import com.example.demo.entitiy.Course;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Data
public class StudentCourseDto {
    private int id;
    private List<CourseDto> courseTaken;
}
