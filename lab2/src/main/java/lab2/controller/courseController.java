package lab2.controller;

import lab2.model.Course;
import lab2.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class courseController {

    @Autowired
    private courseService courseService;
    @GetMapping
    public List<Course> getAllCourse(){

        return courseService.getAllCourses();

    }
    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable int id){
            return courseService.getCourseById(id);
        }
    @PostMapping
    public void saveCourse

}
