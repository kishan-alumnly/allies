package com.example.allies.employee.service;

import com.example.allies.employee.entity.EmployeeEntity;
import com.example.allies.employee.model.EmployeeModel;

import java.util.List;

public interface EmployeeService {

    // Method to get an employee by ID
    EmployeeModel getEmployee(String id);

    // Method to get all employees
    List<EmployeeModel> getAllEmployees();

    // Method to get employees by department ID
    List<EmployeeModel> getEmployeesByDepartment(String departmentId);

    // Method to add a new employee to a department
    EmployeeModel addEmployee(String departmentId, EmployeeEntity employee);

    // Method to delete an employee by ID
    void deleteEmployee(String employeeId);

}
