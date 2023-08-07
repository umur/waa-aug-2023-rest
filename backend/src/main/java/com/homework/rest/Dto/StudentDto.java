package com.homework.rest.Dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentDto {
    private String id;
    private String firstName;
    private  String lastName;
    private String email;
    private String major;
    private String[] courseTaken;

    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                "name='" + firstName + '\'' +
                ", code='" + lastName + '\'' +
                ", code='" + email + '\'' +
                ", code='" + major + '\'' +
                ", code='" + courseTaken + '\'' +
                '}';
    }
}
