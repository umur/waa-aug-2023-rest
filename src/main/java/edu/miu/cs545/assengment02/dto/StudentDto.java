package edu.miu.cs545.assengment02.dto;

import edu.miu.cs545.assengment02.entity.Course;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class StudentDto {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken;
}
