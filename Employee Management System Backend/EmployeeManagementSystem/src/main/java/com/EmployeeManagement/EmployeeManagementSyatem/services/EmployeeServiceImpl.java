package com.EmployeeManagement.EmployeeManagementSyatem.services;

import com.EmployeeManagement.EmployeeManagementSyatem.entity.EmployeeEntity;
import com.EmployeeManagement.EmployeeManagementSyatem.model.Employee;
import com.EmployeeManagement.EmployeeManagementSyatem.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employee,employeeEntity);
        employeeRepository.save(employeeEntity);
        return employee;
    }
    @Override
    public List<Employee> getAllEmployee(){
        Employee empUI = new Employee();
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        List<Employee> empUIList = employeeEntities.stream().map(emp -> new Employee(emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmailId())).collect(Collectors.toList());
        return empUIList;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        EmployeeEntity employee = employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
        return true;
    }
}
