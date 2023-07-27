package com.example.demo.service.impl;

import com.example.demo.dto.CourseDto;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.service.CourseService;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final StudentService studentService;

    @Override
    public void saveCourse(CourseDto courseDto) {
        Course courseEntity = new Course();
        courseEntity.setId(courseDto.getId());
        courseEntity.setCode(courseDto.getCode());
        courseEntity.setName(courseDto.getName());

        courseRepository.saveCourse(courseEntity);

    }

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courseEntityList = courseRepository.getAllCourses();
        return getCourseDtos(courseEntityList);
    }

    @Override
    public List<CourseDto> getCoursesByStudentId(int studentId) {
       Optional<StudentDto> studentDto = studentService.getStudentById(studentId);
       List<Course> courseList = studentDto.get().getCoursesTaken();
        return getCourseDtos(courseList);
    }

    private List<CourseDto> getCourseDtos(List<Course> courseList) {
        List<CourseDto>dtoList = new ArrayList<>();
        courseList.forEach(course -> {
            var dto = new CourseDto();
            dto.setId(course.getId());
            dto.setName(course.getName());
            dto.setCode(course.getCode());
            dtoList.add(dto);
        });

        return dtoList;
    }
}
