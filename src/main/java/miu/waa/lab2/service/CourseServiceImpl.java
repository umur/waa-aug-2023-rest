package miu.waa.lab2.service;

import lombok.RequiredArgsConstructor;
import miu.waa.lab2.dto.CourseDto;
import miu.waa.lab2.entity.Course;
import miu.waa.lab2.repository.CourseRepo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepo courseRepo;

    @Override
    public Map<Integer, CourseDto> getAll() {
        Map<Integer, Course> coursesMap = courseRepo.getAll();
        Map<Integer, CourseDto> dtoMap =  new HashMap<>();
        coursesMap.forEach((k, c) -> {
            var dto = new CourseDto();
            dto.setId(c.getId());
            dto.setName(c.getName());
            dto.setCode(c.getCode());
            dtoMap.put(k,dto);
        });
        return dtoMap;
    }

    @Override
    public void create(CourseDto course) {
        Course entity = new Course();
        entity.setId(course.getId());
        entity.setName(course.getName());
        entity.setCode(course.getCode());
        courseRepo.create(entity);
    }

    @Override
    public CourseDto read(int id) {
        Course course = courseRepo.read(id);
        CourseDto dto=new CourseDto();
        dto.setId(course.getId());
        dto.setName(course.getName());
        dto.setCode(course.getCode());
        return dto;
    }

    @Override
    public void update(CourseDto course) {
        Course entity = new Course();
        entity.setId(course.getId());
        entity.setName(course.getName());
        entity.setCode(course.getCode());
        courseRepo.update(entity);
    }

    @Override
    public void delete(int id) {
        courseRepo.delete(id);
    }


}
