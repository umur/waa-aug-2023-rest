package waa.lab2.repository;

import org.springframework.stereotype.Repository;
import waa.lab2.domain.Course;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepository {
    private static List<Course> courseList= new ArrayList<>();

    public void save(Course course){
        courseList.add(course);
    }
    public List<Course> getAll(){
        return courseList;
    }
    public Course getById(int id){
        return  courseList.stream().filter(course -> course.getCourseId()==id).findFirst().orElse(null);
    }
    public void deleteById(int id){
        courseList.stream().filter(cour -> cour.getCourseId() == id).findFirst().ifPresent(course -> courseList.remove(course));

    }
}
