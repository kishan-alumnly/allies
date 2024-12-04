package com.example.allies.department.view;

import com.example.allies.employee.view.EmployeeView;

import java.util.ArrayList;
import java.util.List;

public class DeparmentView {
    private String id;
    private String name;
    private String location;

    List<EmployeeView> employees = new ArrayList<>();

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

    public List<EmployeeView> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeView> employees) {
        this.employees = employees;
    }
}
