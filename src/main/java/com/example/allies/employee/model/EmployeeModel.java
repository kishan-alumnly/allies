package com.example.allies.employee.model;


import com.example.allies.department.model.DeparmentModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class EmployeeModel {
    private String id;
    private String name;
    private String email;
    private String position;
    private Integer salary;

    @JsonIgnore
    private DeparmentModel deparmentModel;

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

    public DeparmentModel getDeparmentModel() {
        return deparmentModel;
    }

    public void setDeparmentModel(DeparmentModel deparmentModel) {
        this.deparmentModel = deparmentModel;
    }
}
