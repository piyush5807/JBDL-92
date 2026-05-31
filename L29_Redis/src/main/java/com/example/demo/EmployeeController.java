package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/v1/employees")
    public Integer createEmployee(@RequestBody Employee employee){
        return this.employeeService.createEmployee(employee);
    }

    @GetMapping("/v1/employees/{id}")
    public Employee getEmployeeDetails(@PathVariable("id") int id){
        return this.employeeService.getEmployee(id);
    }
//
//    @PutMapping("/v1/employees/{id}")
//    public void updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee){
//
//    }




}
