package com.example.demo01.mapper;

import com.example.demo01.dto.StudentDTO;
import com.example.demo01.entity.Student;

public class StudentMapper {
    public static StudentDTO mapToStudentDto(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    public static Student mapToStudent(StudentDTO studentDto) {
        return new Student(
                studentDto.getId(),
                studentDto.getFirstName(),
                studentDto.getLastName(),
                studentDto.getEmail()

        );
    }
}
