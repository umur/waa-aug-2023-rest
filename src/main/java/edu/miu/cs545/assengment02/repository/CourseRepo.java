package edu.miu.cs545.assengment02.repository;

import edu.miu.cs545.assengment02.entity.Course;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepo {

    private List<Course> courses;

    public CourseRepo() {
        this.courses = new ArrayList<>();
    }

    public List<Course> getAll() {
        Course c1 = Course.builder().id(1)
                .name("FPP")
                .code(111).build();
        Course c2 = Course.builder().id(2)
                .name("MPP")
                .code(222).build();
        Course c3 = Course.builder().id(3)
                .name("WAP")
                .code(333).build();
        Course c4 = Course.builder().id(4)
                .name("WAA")
                .code(444).build();
        courses.addAll(Arrays.asList(c1,c2,c3,c4));

        return courses;
    }

    public void save(Course course){
        this.courses.add(course);
       //courses.stream().forEach(System.out::println);
    }

    public Course getOneById(int id) {
        Optional<Course> first = courses.stream().filter(c -> c.getId() == id).findFirst();
        if(first.isPresent())
            return first.get();
        return null;
    }

    public void update(Course entity, int id) {
        for (int i = 0; i > courses.size(); i++) {
            if (courses.get(i).getId() == id) {
                courses.get(i).setName(entity.getName());
                courses.get(i).setCode(entity.getCode());
            }
        }
        courses.stream().forEach(System.out::println);
    }

    public void delete(int id) {
        courses.removeIf(course -> course.getId() == id);
        courses.stream().forEach(System.out::println);
    }
}
