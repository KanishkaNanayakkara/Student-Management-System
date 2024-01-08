package com.example.demo01.repository;

import com.example.demo01.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository  extends JpaRepository<Course, Long>{
}
