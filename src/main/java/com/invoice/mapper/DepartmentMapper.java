package com.invoice.mapper;

import com.invoice.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface DepartmentMapper {
    @Select("select * from department where department_username=#{username}")
    Department getDepartmentByUserName(String username);
}
