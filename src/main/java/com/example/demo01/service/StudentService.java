package com.example.demo01.service;

import com.example.demo01.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto createStudent(StudentDto studentDto);
    StudentDto getStudentByID(Long studentId);
    List<StudentDto> getAllStudents();
    StudentDto updateStudent(Long studentId, StudentDto updatedEmployee);
    void deleteStudent(Long studentId );

}
