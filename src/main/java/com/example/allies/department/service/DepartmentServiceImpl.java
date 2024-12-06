package com.example.allies.department.service;

import com.example.allies.department.entity.DepartmentEntity;
import com.example.allies.department.repository.DepartmentRepository;
import com.example.allies.department.model.DeparmentModel;
import com.example.allies.employee.entity.EmployeeEntity;
import com.example.allies.employee.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public List<DeparmentModel> getAllDepartments(){
        List<DepartmentEntity> departmentEntities = departmentRepository.findAll();
        List<DeparmentModel> departmentModels = new ArrayList<>();

        for (DepartmentEntity departmentEntity : departmentEntities) {
            DeparmentModel departmentView = mapToDeparmentView(departmentEntity);
            departmentModels.add(departmentView);
        }

        return departmentModels;
    }

    private DeparmentModel mapToDeparmentView(DepartmentEntity departmentEntity) {
        DeparmentModel deparmentModel = new DeparmentModel();
        deparmentModel.setId(departmentEntity.getId());
        deparmentModel.setName(departmentEntity.getName());
        deparmentModel.setLocation(departmentEntity.getLocation());
        deparmentModel.setEmployeeModels(mapToEmployeeViews(departmentEntity.getEmployeeEntities()));
        return deparmentModel;
    }

    private List<EmployeeModel> mapToEmployeeViews(List<EmployeeEntity> employeeEntities) {
        List<EmployeeModel> employeeModels = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employeeEntities) {
            EmployeeModel employeeModel = new EmployeeModel();
            employeeModel.setId(employeeEntity.getId());
            employeeModel.setName(employeeEntity.getName());
            employeeModel.setEmail(employeeEntity.getEmail());
            employeeModel.setPosition(employeeEntity.getPosition());
            employeeModel.setSalary(employeeEntity.getSalary());
            employeeModels.add(employeeModel);
        }
        return employeeModels;
    }
}
