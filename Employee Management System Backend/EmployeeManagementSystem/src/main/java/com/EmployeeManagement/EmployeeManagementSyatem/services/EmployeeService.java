package com.EmployeeManagement.EmployeeManagementSyatem.services;

import com.EmployeeManagement.EmployeeManagementSyatem.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    List<Employee> getAllEmployee();
    boolean deleteEmployee(@PathVariable Long id);
}
