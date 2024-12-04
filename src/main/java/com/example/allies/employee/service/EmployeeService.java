
package com.example.allies.employee.service;

import com.example.allies.department.model.DepartmentModel;
import com.example.allies.department.repository.DepartmentRepository;
import com.example.allies.department.view.DeparmentView;
import com.example.allies.employee.model.EmployeeModel;
import com.example.allies.employee.repository.EmployeeRepository;
import com.example.allies.employee.view.EmployeeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public EmployeeView getEmployee(String id) {
        EmployeeModel employeeModel = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        return mapToEmployeeView(employeeModel);
    }

    public List<EmployeeView> getAllEmployees() {
        List<EmployeeModel> employeeModels = employeeRepository.findAll();
        return employeeModels.stream()
                .map(this::mapToEmployeeView)
                .collect(Collectors.toList());
    }

    public List<EmployeeView> getEmployeesByDepartment(String departmentId) {
        DepartmentModel department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        return department.getEmployees().stream()
                .map(this::mapToEmployeeView)
                .collect(Collectors.toList());
    }

    public EmployeeView addEmployee(String departmentId, EmployeeModel employee) {
        DepartmentModel department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        employee.setDepartment(department);
        return mapToEmployeeView(employeeRepository.save(employee));
    }

    public void deleteEmployee(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    private EmployeeView mapToEmployeeView(EmployeeModel employeeModel) {
        EmployeeView employeeView = new EmployeeView();
        employeeView.setId(employeeModel.getId());
        employeeView.setName(employeeModel.getName());
        employeeView.setEmail(employeeModel.getEmail());
        employeeView.setPosition(employeeModel.getPosition());
        employeeView.setSalary(employeeModel.getSalary());
        DepartmentModel departmentModel = departmentRepository.getById(employeeModel.getDepartment().getId());
        employeeView.setDeparmentView(mapToDeparmentView(departmentModel));
        return employeeView;
    }

    private DeparmentView mapToDeparmentView(DepartmentModel department) {
        DeparmentView departmentView = new DeparmentView();
        departmentView.setId(department.getId());
        departmentView.setName(department.getName());
        departmentView.setLocation(department.getLocation());
        return departmentView;
    }
}
