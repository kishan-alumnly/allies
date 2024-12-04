package com.example.allies.department.repository;

import com.example.allies.department.model.DepartmentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentModel, String> {
}
