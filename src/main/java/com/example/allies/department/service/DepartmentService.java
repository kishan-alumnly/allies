package com.example.allies.department.service;

import com.example.allies.department.model.DepartmentModel;
import com.example.allies.department.repository.DepartmentRepository;
import com.example.allies.department.view.DeparmentView;
import com.example.allies.employee.model.EmployeeModel;
import com.example.allies.employee.view.EmployeeView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<DeparmentView> getAllDepartments(){
        List<DepartmentModel> departments = departmentRepository.findAll();
        List<DeparmentView> departmentViews = new ArrayList<>();

        for (DepartmentModel department : departments) {
            DeparmentView departmentView = mapToDeparmentView(department);
            departmentViews.add(departmentView);
        }

        return departmentViews;
    }

    private static List<EmployeeView> getEmployeeViews(DepartmentModel department) {
        List<EmployeeView> employeeViews = new ArrayList<>();
        for(EmployeeModel employee: department.getEmployees()){
            EmployeeView employeeView = new EmployeeView();
            employeeView.setId(employee.getId());
            employeeView.setName(employee.getName());
            employeeView.setEmail(employee.getEmail());
            employeeView.setPosition(employee.getPosition());
            employeeView.setSalary(employee.getSalary());
            employeeViews.add(employeeView);
        }
        return employeeViews;
    }

    private DeparmentView mapToDeparmentView(DepartmentModel department) {
        DeparmentView departmentView = new DeparmentView();
        departmentView.setId(department.getId());
        departmentView.setName(department.getName());
        departmentView.setLocation(department.getLocation());
        departmentView.setEmployees(mapToEmployeeViews(department.getEmployees()));
        return departmentView;
    }

    private List<EmployeeView> mapToEmployeeViews(List<EmployeeModel> employees) {
        List<EmployeeView> employeeViews = new ArrayList<>();
        for (EmployeeModel employee : employees) {
            EmployeeView employeeView = new EmployeeView();
            employeeView.setId(employee.getId());
            employeeView.setName(employee.getName());
            employeeView.setEmail(employee.getEmail());
            employeeView.setPosition(employee.getPosition());
            employeeView.setSalary(employee.getSalary());
            employeeViews.add(employeeView);
        }
        return employeeViews;
    }
}
