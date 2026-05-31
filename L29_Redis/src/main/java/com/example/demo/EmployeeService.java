package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    EmployeeCacheRepository employeeCacheRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public Integer createEmployee(Employee employee){
        Integer employeeId = this.employeeRepository.save(employee).getId();
//        this.employeeCacheRepository.insert(employee); // write through cache
        return employeeId;
    }

    public Employee getEmployee(Integer id){
        Employee employee = this.employeeCacheRepository.get(id);
        if(employee != null){
            return employee;      // Cache hit
        }

        employee = this.employeeRepository.findById(id).orElse(null);    // Cache miss, going to db
        if(employee == null){
            return null;
        }

        this.employeeCacheRepository.insert(employee); // populating the cache with the data fetched from db
        return employee;
    }

    public void updateEmployee(Employee employee){

        /**
         * If cache aside, then delete the data from redis
         * If cache through, then update the data then and there only, no need to delete.
         */
    }
}
