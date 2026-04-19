package com.example.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1")
public class EmployeeController {

    /**
     * 1. API for adding an employee to the system : stored in hashmap
     * 2. API for retrieving the details of an employee given an employee id
     * 3. API for deleting the employee from the system
     * 4. API for updating the employee details in the system
     *
     * CRUD -
     *
     *
     * API can consists of
     * 1. Request method -
     * 2. Input params sent by client
     * 3. Output data to be sent by the server
     * 4. Path - server developer decides
     *
     *
     * Rest - representation state transfer
     * GET, POST, PATCH, PUT, DELETE, HEAD...
     *
     * POST /user => {name: Jim, age: 20, country: India, email: jim@google.com}   =>  Store the data in the data storage and will return the response
     *
     * POST /user => {name: Jim, age: 20, country: India, email: jim@google.com}   => Don't store the data as it's duplicate, instead throw 400 BAD Request
     *
     * Use camel case in your endpoint's path, every letter should be lowercase
     */

    // Action               +           Model
    // Create / Save                    Employee
    // GET / Retrieve                   Employee

    /**
     * RequestParam : Input data being taken as part of the url in form key value pairs separated by ?
     * Path Variable / Path params : Input data is taken as part of url again but not as a key value pair after the endpoint, but it's included in the endpoint itself
     * RequestBody : Input data is taken as part of a json in the body instead of taking in the url
     * JSON --> Java Object
     *
     * //-------
     * ResponseBody - Output data sent from server to client
     * Java object --> JSON
     */

    @Autowired
    private Utils utils;

    // employee id --> employee mapping
    private Map<String, Employee> employeeMap = new HashMap();

    @PostMapping("/employees")   // POST /employee
    public String createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest){
        String id = utils.generateEmployeeId();
        Employee employee = utils.convertToEmployee(createEmployeeRequest, id, false);

        this.employeeMap.put(id, employee);
        return id;
    }

    @PutMapping("/employees/{employeeId}")
    public void updateEmployee(@PathVariable("employeeId") String employeeId,
                               @RequestBody UpdateEmployeeRequest updateEmployeeRequest){
        Employee employee = this.utils.convertToEmployee(updateEmployeeRequest, employeeId, true);
        this.employeeMap.put(employeeId, employee);
    }

    // Update the data that is coming from client, keep the rest of fields same as before, don't update the rest of the fields to null / default
    @PatchMapping("/employees/{employeeId}")
    public void updateEmployeePartially(@PathVariable("employeeId") String employeeId,
                                        @RequestBody UpdateEmployeeRequest updateEmployeeRequest){
        Employee employee = this.employeeMap.getOrDefault(employeeId, null); // db call / nw call
        employee = this.utils.convertToEmployee(updateEmployeeRequest, employeeId, employee, true);
        this.employeeMap.put(employeeId, employee);
    }

//    @PostMapping("/employees")
//    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest){
//        String id = utils.generateEmployeeId();
//        Employee employee = utils.convertToEmployee(employeeRequest, id);
//
//        this.employeeMap.put(id, employee);
//        return employee;
//    }


    // GET localhost:8080/employees/1/Jim
    @GetMapping("/employees/{employeeId}")
    public EmployeeResponse getEmployee(@PathVariable("employeeId") String empId){
//                                @PathVariable("employee-name") String empName){
        Employee employee = this.employeeMap.get(empId);
        if(employee != null){
            return this.utils.convertToEmployeeResponse(employee);
        }

        return null;
    }

    @GetMapping("/employees-all")
    public List<EmployeeResponse> getAllEmployees(){

        Collection<Employee> employees = this.employeeMap.values();
        return employees.stream()
                .map(employee -> this.utils.convertToEmployeeResponse(employee))
                .collect(Collectors.toList());
    }


    // GET localhost:8080/employees?id=1&name=Jim
    @DeleteMapping("/employees")
    public EmployeeResponse deleteEmployee(@RequestParam(value = "id") String empId){

        Employee employee = this.employeeMap.remove(empId);
        if(employee != null){
            return this.utils.convertToEmployeeResponse(employee);
        }

        return null;
    }

    // localhost:8080/oms/orders/RH_12345?orgId=dfb8e5e6-1544-41fd-8708-63e2e2da0813
    // localhost:8080/oms/org/dfb8e5e6-1544-41fd-8708-63e2e2da0813/orders/RH_12345

//    @GetMapping("/oms/orders/{orderId}")
//    public Order getOrders(@PathVariable("orderId") String orderId,
//                           @RequestParam("orgId") String orgId)

    /**
     * https://staging.rhblade.com   -- dns
     *
     * Path - /oms/orders/{orderId}
     *
     * Request Param - orgId=dfb8e5e6-1544-41fd-8708-63e2e2da0813
     */

    // referrer=https://www.canva.com/s/templates?query=&adj

    /**
     * https://www.canva.com/design/DAHGodNFGpE/cXwISGhn-LTK2pG8KCRTQA/edit?referrer=https%3A%2F%2Fwww.canva.com%2Fs%2Ftemplates%3Fquery%3D%26adj%3DeyJFIjp7IkEiOiJ0QUNaQ2tpNHRiWSJ9fQ

     https://www.canva.com/design/DAHGodNFGpE/cXwISGhn-LTK2pG8KCRTQA/https://www.canva.com/s/templates?query=&adj/edit
     */

}
