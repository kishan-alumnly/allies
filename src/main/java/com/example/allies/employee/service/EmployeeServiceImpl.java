
package com.example.allies.employee.service;

import com.example.allies.department.entity.DepartmentEntity;
import com.example.allies.department.repository.DepartmentRepository;
import com.example.allies.department.model.DeparmentModel;
import com.example.allies.employee.entity.EmployeeEntity;
import com.example.allies.employee.repository.EmployeeRepository;
import com.example.allies.employee.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService  {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeServiceImpl(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public EmployeeModel getEmployee(String id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        return mapToEmployeeView(employeeEntity);
    }

    public List<EmployeeModel> getAllEmployees() {
        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return employeeEntities.stream()
                .map(this::mapToEmployeeView)
                .collect(Collectors.toList());
    }

    public List<EmployeeModel> getEmployeesByDepartment(String departmentId) {
        DepartmentEntity department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        return department.getEmployeeEntities().stream()
                .map(this::mapToEmployeeView)
                .collect(Collectors.toList());
    }

    public EmployeeModel addEmployee(String departmentId, EmployeeEntity employee) {
        DepartmentEntity department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new RuntimeException("Department not found"));
        employee.setDepartmentEntity(department);
        return mapToEmployeeView(employeeRepository.save(employee));
    }

    public void deleteEmployee(String employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    private EmployeeModel mapToEmployeeView(EmployeeEntity employeeEntity) {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setId(employeeEntity.getId());
        employeeModel.setName(employeeEntity.getName());
        employeeModel.setEmail(employeeEntity.getEmail());
        employeeModel.setPosition(employeeEntity.getPosition());
        employeeModel.setSalary(employeeEntity.getSalary());
        DepartmentEntity departmentModel = departmentRepository.getById(employeeEntity.getDepartmentEntity().getId());
        employeeModel.setDeparmentModel(mapToDeparmentView(departmentModel));
        return employeeModel;
    }

    private DeparmentModel mapToDeparmentView(DepartmentEntity department) {
        DeparmentModel departmentView = new DeparmentModel();
        departmentView.setId(department.getId());
        departmentView.setName(department.getName());
        departmentView.setLocation(department.getLocation());
        return departmentView;
    }
}
