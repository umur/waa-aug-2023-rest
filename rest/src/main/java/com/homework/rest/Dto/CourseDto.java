package com.homework.rest.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {
    String id;
    String name;
    String code;
    @Override
    public String toString() {
        return "CourseDto{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
