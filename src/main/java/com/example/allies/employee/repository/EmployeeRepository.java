package com.example.allies.employee.repository;

import com.example.allies.employee.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, String> {
}
