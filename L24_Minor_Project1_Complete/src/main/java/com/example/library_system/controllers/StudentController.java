package com.example.library_system.controllers;

import com.example.library_system.dtos.CreateStudentRequest;
import com.example.library_system.models.Student;
import com.example.library_system.services.StudentService;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/students")
    public Integer createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest){
        return this.studentService.createStudent(createStudentRequest);
    }

    @GetMapping("/students/{studentId}")
    public Student getStudentDetails(@PathVariable("studentId") Integer id){
        return this.studentService.getStudentDetails(id);
    }
}
