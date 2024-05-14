package com.example.TransactionalOutBoxPattern.service;

import com.example.TransactionalOutBoxPattern.UserMapper.DepartmentMapper;
import com.example.TransactionalOutBoxPattern.dto.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public void createDepartment(Department department) {
        departmentMapper.insertDepartment(department);
    }

    public List<Department> getDepartment(String departmentId) {
        return departmentMapper.getDepartment(departmentId);
    }

}