package com.example.allies.department.repository;

import com.example.allies.department.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, String> {
}
