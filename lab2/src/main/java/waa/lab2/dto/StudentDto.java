package waa.lab2.dto;

import lombok.Data;
import waa.lab2.domain.Course;

import java.util.List;
@Data
public class StudentDto {
    private int studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
//    private List<Course> coursesTaken;
}
