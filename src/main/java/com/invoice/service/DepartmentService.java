package com.invoice.service;

import com.invoice.entity.Department;

public interface DepartmentService {
    Department getDepartmentByName(String username);
    void addDepartment(Department department);
    void deleteDepartment(Department department);

}
