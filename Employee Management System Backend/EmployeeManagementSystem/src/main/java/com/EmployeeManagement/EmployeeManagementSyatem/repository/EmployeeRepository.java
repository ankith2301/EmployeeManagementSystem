package com.EmployeeManagement.EmployeeManagementSyatem.repository;

import com.EmployeeManagement.EmployeeManagementSyatem.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
