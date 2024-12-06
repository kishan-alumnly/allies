package com.example.allies.employee.entity;

import com.example.allies.department.entity.DepartmentEntity;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    private String id;
    private String name;
    private String email;
    private String position;
    private Integer salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private DepartmentEntity departmentEntity;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public DepartmentEntity getDepartmentEntity() {
        return departmentEntity;
    }

    public void setDepartmentEntity(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }
}

