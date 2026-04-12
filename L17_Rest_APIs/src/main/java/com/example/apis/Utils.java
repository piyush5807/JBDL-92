package com.example.apis;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

//@Configuration
@Component
public class Utils {


//    @Bean
    public String generateEmployeeId() {
        return UUID.randomUUID().toString();
    }

    // DTO - Data transfer object
    public Employee convertToEmployee(EmployeeRequest employeeRequest, String employeeId, boolean isUpdate) {
        Employee employee = new Employee();
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setCountry(employeeRequest.getCountry());
        employee.setAge(employeeRequest.getAge());
        employee.setGender(employeeRequest.getGender());

        // Not provided by client, added by the server
        employee.setId(employeeId);
        employee.setLastUpdatedAt(new Date());
        if(!isUpdate){
            employee.setCreatedAt(new Date());
        }

        return employee;
    }

    public EmployeeResponse convertToEmployeeResponse(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setId(employee.getId());
        employeeResponse.setFirstName(employee.getFirstName());
        employeeResponse.setLastName(employee.getLastName());
        employeeResponse.setEmail(employee.getEmail());
        employeeResponse.setCountry(employee.getCountry());
        employeeResponse.setAge(employee.getAge());
        employeeResponse.setGender(employee.getGender());
        employeeResponse.setCreatedAt(employee.getCreatedAt());
        employeeResponse.setLastUpdatedAt(employee.getLastUpdatedAt());

        return employeeResponse;

    }
}
