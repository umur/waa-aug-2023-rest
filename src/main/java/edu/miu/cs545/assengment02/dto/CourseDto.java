package edu.miu.cs545.assengment02.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CourseDto {
    private int id;
    private String name;
    private int code;

}
