package com.example.allies.employee.view;


import com.example.allies.department.view.DeparmentView;

public class EmployeeView {
    private String id;
    private String name;
    private String email;
    private String position;
    private Integer salary;
    private DeparmentView deparmentView;

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

    public DeparmentView getDeparmentView() {
        return deparmentView;
    }

    public void setDeparmentView(DeparmentView deparmentView) {
        this.deparmentView = deparmentView;
    }
}
