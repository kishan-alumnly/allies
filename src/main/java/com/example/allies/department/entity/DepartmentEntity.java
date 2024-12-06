package com.example.allies.department.entity;

import com.example.allies.employee.entity.EmployeeEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class DepartmentEntity {
    @Id
    private String id;
    private String name;
    private String location;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")  // Foreign key column
    List<EmployeeEntity> employeeEntities = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<EmployeeEntity> getEmployeeEntities() {
        return employeeEntities;
    }

    public void setEmployeeEntities(List<EmployeeEntity> employeeEntities) {
        this.employeeEntities = employeeEntities;
    }
}
