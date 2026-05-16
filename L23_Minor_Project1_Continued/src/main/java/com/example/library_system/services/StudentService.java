package com.example.library_system.services;

import com.example.library_system.dtos.CreateStudentRequest;
import com.example.library_system.models.Student;
import com.example.library_system.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Integer createStudent(CreateStudentRequest createStudentRequest){

        Student student = createStudentRequest.to();
        this.studentRepository.save(student);

        return student.getId();
    }

    public Student getStudentDetails(Integer id) {

        return this.studentRepository.findById(id)
                .orElse(null);
    }
}
