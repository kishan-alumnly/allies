package com.example.allies.employee.repository;

import com.example.allies.employee.model.EmployeeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeModel, String> {
}
