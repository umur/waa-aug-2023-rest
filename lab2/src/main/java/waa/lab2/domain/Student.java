package waa.lab2.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<Course> coursesTaken= new ArrayList<>();

    public void addCourse(Course course){
        coursesTaken.add(course);
    }
}
