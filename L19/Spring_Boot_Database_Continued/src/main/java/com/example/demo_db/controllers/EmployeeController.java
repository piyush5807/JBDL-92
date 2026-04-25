package com.example.demo_db.controllers;

import com.example.demo_db.dtos.requests.CreateEmployeeRequest;
import com.example.demo_db.models.Employee;
import com.example.demo_db.dtos.responses.EmployeeResponse;
import com.example.demo_db.services.EmployeeService;
import com.example.demo_db.services.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")   // POST /employee
    public void createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest) throws SQLException {
        this.employeeService.createEmployee(createEmployeeRequest);
    }


    @GetMapping("/employees/{employeeId}")
    public EmployeeResponse getEmployee(@PathVariable("employeeId") Integer empId) throws SQLException {
        return this.employeeService.getEmployee(empId);
    }

    @GetMapping("/employees-all")
    public List<EmployeeResponse> getAllEmployees() throws SQLException {
        return this.employeeService.getEmployees();
    }

    // DELETE
    // PATCH / PUT --> update employee set .... where id = ?

}
