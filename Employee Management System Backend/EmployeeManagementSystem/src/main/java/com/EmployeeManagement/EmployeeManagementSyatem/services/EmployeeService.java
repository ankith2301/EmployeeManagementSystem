package com.EmployeeManagement.EmployeeManagementSyatem.services;

import com.EmployeeManagement.EmployeeManagementSyatem.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);
    List<Employee> getAllEmployee();
}
