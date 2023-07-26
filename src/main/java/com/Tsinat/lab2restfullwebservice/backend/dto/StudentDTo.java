package com.Tsinat.lab2restfullwebservice.backend.dto;

import java.util.List;

public class StudentDTo {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private List<CourseDTo> coursesTaken;
}
