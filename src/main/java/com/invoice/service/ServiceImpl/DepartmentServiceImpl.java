package com.invoice.service.ServiceImpl;

import com.invoice.entity.Department;
import com.invoice.mapper.DepartmentMapper;
import com.invoice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public Department getDepartmentByUserName(String username) {
        return departmentMapper.getDepartmentByUserName(username);
    }
}
