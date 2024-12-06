package com.example.allies.department.model;

import com.example.allies.employee.model.EmployeeModel;

import java.util.ArrayList;
import java.util.List;

public class DeparmentModel {
    private String id;
    private String name;
    private String location;

    List<EmployeeModel> employeeModels = new ArrayList<>();

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

    public List<EmployeeModel> getEmployeeModels() {
        return employeeModels;
    }

    public void setEmployeeModels(List<EmployeeModel> employeeModels) {
        this.employeeModels = employeeModels;
    }
}
