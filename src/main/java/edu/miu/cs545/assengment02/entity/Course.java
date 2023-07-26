package edu.miu.cs545.assengment02.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Builder
@ToString
public class Course {

    private int id;
    private String name;
    private int code;

}
