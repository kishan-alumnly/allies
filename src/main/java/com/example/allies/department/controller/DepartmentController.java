package com.example.allies.department.controller;

import com.example.allies.department.service.DepartmentService;
import com.example.allies.department.model.DeparmentModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<DeparmentModel> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

}
