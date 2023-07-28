package com.homework.rest.Entity;

import java.util.Arrays;
import java.util.List;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String major;
    private String[] courseTaken;

    public Student(String id, String firstName, String lastName, String email, String[] courseTaken) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.courseTaken = courseTaken;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String[] getCourseTaken() {
        return courseTaken;
    }

    public void setCourseTaken(String[] courseTaken) {
        this.courseTaken = courseTaken;
    }

    public Student(String id, String firstName, String lastName, String email, String major, String[] courseTaken) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.major = major;
        this.courseTaken = courseTaken;
    }

    public Student() {}

    @Override
    public String toString() {
        return "{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", major='" + major + '\'' +
                ", courseTaken='" + Arrays.toString(courseTaken) + '\'' +
                '}';
    }
 }
