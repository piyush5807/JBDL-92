package com.example.library_system.dtos;

import com.example.library_system.models.Department;
import com.example.library_system.models.Student;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStudentRequest {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String rollNumber;

    private Department department;

    public Student to(){
        return Student.builder()
                .rollNumber(this.rollNumber)
                .email(this.email)
                .name(this.name)
                .department(this.department)
                .build();
    }
}
