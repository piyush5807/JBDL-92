package com.example.demo_db.controllers;

import com.example.demo_db.dtos.requests.CreateEmployeeRequest;
import com.example.demo_db.models.Employee;
import com.example.demo_db.dtos.responses.EmployeeResponse;
import com.example.demo_db.services.EmployeeService;
import com.example.demo_db.services.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")   // POST /employee
    public String createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest){
        return this.employeeService.createEmployee(createEmployeeRequest);
    }


    @GetMapping("/employees/{employeeId}")
    public EmployeeResponse getEmployee(@PathVariable("employeeId") Integer empId){
        return this.employeeService.getEmployee(empId);
    }

    @GetMapping("/employees-all")
    public List<EmployeeResponse> getAllEmployees(){
        return this.employeeService.getEmployees();
    }

}
