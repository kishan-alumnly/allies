package com.example.allies.employee.controller;

import com.example.allies.employee.entity.EmployeeEntity;
import com.example.allies.employee.service.EmployeeServiceImpl;
import com.example.allies.employee.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("{employeeId}")
    public EmployeeModel getEmployee(@PathVariable String employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @GetMapping
    public List<EmployeeModel> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/department/{departmentId}")
    public List<EmployeeModel> getEmployeesByDepartment(@PathVariable String departmentId) {
        return employeeService.getEmployeesByDepartment(departmentId);
    }

    @PostMapping("/department/{departmentId}")
    public EmployeeModel addEmployee(@PathVariable String departmentId, @RequestBody EmployeeEntity employee) {
        return employeeService.addEmployee(departmentId, employee);
    }

    @DeleteMapping("/delete/{employeeId}")
    public void deleteEmployee(@PathVariable String employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

}
