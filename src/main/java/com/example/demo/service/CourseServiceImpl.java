package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Course;
import com.example.demo.entity.Student;
import com.example.demo.repository.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService{

    @Autowired
    private final CourseRepo courseRepo;
    @Override
    public void save(CourseDto course) {
        courseRepo.save(convertToEntity(course));
    }

    @Override
    public List<CourseDto> getAll() {
        List<Course> courses = courseRepo.getAll();
        return convertToDtoList(courses);
    }

    @Override
    public CourseDto getById(int id) {
        List<Course> courses = courseRepo.getAll();
        Course courseEntity =  courses.stream()
                .filter(course -> course.getId() == id)
                .findFirst()
                .orElse(null);

        return convertToDto(courseEntity);
    }

    @Override
    public void update(CourseDto courseDto, int id) {
        courseRepo.update(convertToEntity(courseDto), id);
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }

    private List<CourseDto> convertToDtoList(List<Course> courses) {
        List<CourseDto> courseDtoList = new ArrayList<>();
        for (Course course : courses) {
           CourseDto courseDto = new CourseDto();
           courseDto.setCode(course.getCode());
           courseDto.setId(course.getId());
           courseDto.setName(course.getName());
            courseDtoList.add(courseDto);
        }
        return courseDtoList;
    }

    static CourseDto convertToDto(Course course){
        if(course == null) return null;
        CourseDto courseDto = new CourseDto();
        courseDto.setCode(course.getCode());
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        return courseDto;
    }

    private Course convertToEntity(CourseDto courseDto){
        if(courseDto == null) return null;
        Course course = new Course();
        course.setCode(courseDto.getCode());
        course.setId(courseDto.getId());
        course.setName(courseDto.getName());
        return course;
    }
}
