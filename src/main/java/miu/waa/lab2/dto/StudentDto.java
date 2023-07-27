package miu.waa.lab2.dto;

import lombok.Getter;
import lombok.Setter;
import miu.waa.lab2.entity.Course;

import java.util.ArrayList;

@Getter
@Setter
public class StudentDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private ArrayList<Course> coursesTaken;
}
