package org.haileab.lab2restfullwebservice.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<CourseDTo> coursesTaken;
}
