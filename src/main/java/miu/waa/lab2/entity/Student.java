package miu.waa.lab2.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private ArrayList<Course> coursesTaken;
}
