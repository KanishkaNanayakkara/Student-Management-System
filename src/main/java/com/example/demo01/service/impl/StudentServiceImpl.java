package com.example.demo01.service.impl;

import com.example.demo01.dto.StudentDTO;
import com.example.demo01.entity.Student;
import com.example.demo01.exception.ResourceNotFoundException;
import com.example.demo01.mapper.StudentMapper;
import com.example.demo01.repository.StudentRepository;
import com.example.demo01.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class StudentServiceImpl implements StudentService {
    private StudentRepository studentRepository;

    @Override

    public StudentDTO createStudent(StudentDTO studentDto) {
        Student student = StudentMapper.mapToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);
        return StudentMapper.mapToStudentDto(savedStudent);
    }

    @Override

    public StudentDTO getStudentByID(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student is not exist with given id : " + studentId));
        return StudentMapper.mapToStudentDto(student);
    }

    @Override

    public List<StudentDTO> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream().map((student -> StudentMapper.mapToStudentDto(student)))
                .collect(Collectors.toList());
    }

    @Override

    public StudentDTO updateStudent(Long studentId, StudentDTO updatedStudent) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException("Student with the given id is  not exist ")
        );
        student.setFirstName(updatedStudent.getFirstName());
        student.setLastName(updatedStudent.getLastName());
        student.setEmail(updatedStudent.getEmail());

        Student updatedStudentobj = studentRepository.save(student);
        return StudentMapper.mapToStudentDto((updatedStudentobj));
    }

    @Override

    public void deleteStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new ResourceNotFoundException("Student with the given id is  not exist ")
        );

        studentRepository.deleteById((studentId));
    }

}
