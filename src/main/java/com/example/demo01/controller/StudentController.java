package com.example.demo01.controller;

import com.example.demo01.dto.StudentDto;
import com.example.demo01.entity.Student;
import com.example.demo01.exception.ResourceNotFoundException;
import com.example.demo01.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/students")

public class StudentController {
    private StudentService studentService;

    //build add student REST API
    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto studentDto){
        StudentDto savedStudent = studentService.createStudent(studentDto);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }
    // build get employee by id REST API
    @GetMapping({"{id}"})
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long studentId){
        StudentDto studentDto = studentService.getStudentByID(studentId);
        return ResponseEntity.ok(studentDto);
    }
    // build get all  employee REST API
    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok(students);
    }
    //update student
    @PutMapping("{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable("id") Long studentId, @RequestBody StudentDto updatedStudent){
        StudentDto studentDto= studentService.updateStudent(studentId,updatedStudent);
        return ResponseEntity.ok(studentDto);
    }
    //delete student
    @DeleteMapping ("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id")Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student record  deleted successfully");
    }
}
