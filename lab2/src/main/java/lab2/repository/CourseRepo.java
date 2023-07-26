package lab2.repository;

import lab2.model.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CourseRepo  {
    private final Map<Integer, Course> coursesMap = new HashMap<>();


    public Course findById(int id) {
        return coursesMap.get(id);
    }


    public List<Course> findAll() {
        return new ArrayList<>(coursesMap.values());
    }


    public void save(Course course) {
        coursesMap.put(course.getId(), course);
    }


    public void update(Course course) {
        coursesMap.put(course.getId(), course);
    }


    public void deleteById(int id) {
        coursesMap.remove(id);
    }


}
