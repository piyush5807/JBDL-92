package com.example.demo_db.services;

import com.example.demo_db.dtos.requests.EmployeeRequest;
import com.example.demo_db.dtos.responses.EmployeeResponse;
import com.example.demo_db.models.Employee;
import com.example.demo_db.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private Utils utils;

    @Autowired
    private EmployeeRepository employeeRepository;


    public String createEmployee(EmployeeRequest employeeRequest){
//        String id = this.utils.generateEmployeeId();
        Employee employee = this.utils.convertToEmployee(employeeRequest, false);

        // TODO:
        this.employeeRepository.createEmployee(employee);

        return null;
    }

    public EmployeeResponse getEmployee(Integer employeeId){

        // TODO: Repository function to get the employee's details
        return null;
    }

    public List<EmployeeResponse> getEmployees(){

        // TODO: Repository function to get the employee's details
        return null;
    }
}
