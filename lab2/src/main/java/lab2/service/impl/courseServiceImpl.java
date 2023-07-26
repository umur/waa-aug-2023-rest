package lab2.service.impl;

import lab2.model.Course;
import lab2.model.Student;
import lab2.repository.CourseRepo;
import lab2.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class courseServiceImpl implements courseService {

    @Autowired
    private CourseRepo courseRepo;


    @Override
    public Course getCourseById(int id) {
        return courseRepo.findById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public void saveCourse(Course course) {
        courseRepo.save(course);

    }

    @Override
    public void updateCourse(Course course) {
        courseRepo.update(course);

    }

    @Override
    public void deleteCourseById(int id) {
        courseRepo.deleteById(id);

    }
}
