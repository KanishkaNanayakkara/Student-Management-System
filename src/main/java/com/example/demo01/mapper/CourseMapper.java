package com.example.demo01.mapper;

import com.example.demo01.dto.CourseDTO;
import com.example.demo01.entity.Course;

public class CourseMapper {
    public static CourseDTO mapToCourseDto(Course course) {
        return new CourseDTO(
                course.getId(),
                course.getTitle(),
                course.getModules(),
                course.getFee(),
                course.getStudents()
        );
    }
    public static Course mapToCourse(CourseDTO courseDto) {
        Course course = new Course();
        course.setId(courseDto.getId());
        course.setTitle(courseDto.getTitle());
        course.setModules(courseDto.getModules());
        course.setFee(courseDto.getFee());
        course.setStudents(courseDto.getStudents());
        return course;
    }
}
