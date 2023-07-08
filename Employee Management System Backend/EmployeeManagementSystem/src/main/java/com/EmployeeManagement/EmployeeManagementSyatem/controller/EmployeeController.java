package com.EmployeeManagement.EmployeeManagementSyatem.controller;

import com.EmployeeManagement.EmployeeManagementSyatem.model.Employee;
import com.EmployeeManagement.EmployeeManagementSyatem.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    private final EmployeeService employeeservice;

    public EmployeeController(EmployeeService employeeservice) {
        this.employeeservice = employeeservice;
    }
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeservice.createEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employeeservice.getAllEmployee();
    }
}
