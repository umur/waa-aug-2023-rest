package edu.miu.cs545.assengment02.service;


import edu.miu.cs545.assengment02.dto.CourseDto;
import edu.miu.cs545.assengment02.entity.Course;
import edu.miu.cs545.assengment02.repository.CourseRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepo repo;


    public List<CourseDto> getAll() {

        List<Course> entities = repo.getAll();
        List<CourseDto> coursesDto = new ArrayList<>();
        entities.forEach(entity ->{
            var dto = CourseDto.builder()
                    .id(entity.getId())
                    .name(entity.getName())
                    .code(entity.getCode())
                     .build();
            coursesDto.add(dto);
        });


        return coursesDto;
    }

    public void save(CourseDto course) {
        Course entity = Course.builder()
                .id(course.getId())
                .code(course.getCode())
                .name(course.getName())
                .build();
        repo.save(entity);
    }

    public void update(CourseDto course, int id) {
        Course entity = repo.getOneById(id);
        if(entity != null){
            entity.setCode(course.getCode());
            entity.setName(course.getName());
            repo.update(entity, id);
        }  else{
            try {
                throw new IllegalAccessException("Course not found");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public CourseDto getOneById(int id) {
        Course entity = repo.getOneById(id);
        if(entity == null) throw new IllegalArgumentException("Course not found");
        return CourseDto.builder()
                .code(entity.getCode())
                .name(entity.getName())
                .build();
    }

    public void delete(int id) {
        repo.delete(id);
    }
}
