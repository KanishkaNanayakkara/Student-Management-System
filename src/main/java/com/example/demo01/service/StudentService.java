package com.example.demo01.service;

import com.example.demo01.dto.StudentDTO;

import java.util.List;

public interface StudentService {
    StudentDTO createStudent(StudentDTO studentDto);
    StudentDTO getStudentByID(Long studentId);
    List<StudentDTO> getAllStudents();
    StudentDTO updateStudent(Long studentId, StudentDTO updatedEmployee);
    void deleteStudent(Long studentId );

}
