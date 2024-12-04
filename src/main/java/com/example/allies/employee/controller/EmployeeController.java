package com.example.allies.employee.controller;

import com.example.allies.employee.model.EmployeeModel;
import com.example.allies.employee.service.EmployeeService;
import com.example.allies.employee.view.EmployeeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("{employeeId}")
    public EmployeeView getEmployee(@PathVariable String employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    @GetMapping
    public List<EmployeeView> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/department/{departmentId}")
    public List<EmployeeView> getEmployeesByDepartment(@PathVariable String departmentId) {
        return employeeService.getEmployeesByDepartment(departmentId);
    }

    @PostMapping("/department/{departmentId}")
    public EmployeeView addEmployee(@PathVariable String departmentId, @RequestBody EmployeeModel employee) {
        return employeeService.addEmployee(departmentId, employee);
    }

    @DeleteMapping("/delete/{employeeId}")
    public void deleteEmployee(@PathVariable String employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

}
