package com.EmployeeManagement.EmployeeManagementSyatem.controller;

import com.EmployeeManagement.EmployeeManagementSyatem.model.Employee;
import com.EmployeeManagement.EmployeeManagementSyatem.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id){
        boolean deleted = false;
        deleted = employeeservice.deleteEmployee(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",deleted);
        return ResponseEntity.ok(response);
    }
}
