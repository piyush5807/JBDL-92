package com.example.demo_db.services;

import com.example.demo_db.dtos.requests.EmployeeRequest;
import com.example.demo_db.dtos.responses.EmployeeResponse;
import com.example.demo_db.models.Employee;
import com.example.demo_db.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private Utils utils;

    @Autowired
    private EmployeeRepository employeeRepository;


    public void createEmployee(EmployeeRequest employeeRequest) throws SQLException {
//        String id = this.utils.generateEmployeeId();
        Employee employee = this.utils.convertToEmployee(employeeRequest, false);

        // TODO:
        this.employeeRepository.createEmployee(employee);
    }

    public EmployeeResponse getEmployee(Integer employeeId) throws SQLException {

        // TODO: Repository function to get the employee's details
        Employee employee = this.employeeRepository.getEmployee(employeeId);
        return this.utils.convertToEmployeeResponse(employee);
    }

    public List<EmployeeResponse> getEmployees() throws SQLException {

        // TODO: Repository function to get the employee's details
        List<Employee> result = this.employeeRepository.getEmployees();
        return result.stream()
                .map(this.utils::convertToEmployeeResponse)
                .collect(Collectors.toList());


    }
}
