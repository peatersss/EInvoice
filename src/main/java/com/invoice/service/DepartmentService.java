package com.invoice.service;

import com.invoice.entity.Department;

public interface DepartmentService {
    Department getDepartmentByUserName(String username);
    Department getDepartmentById(Integer department_id);
}
