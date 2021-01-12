package com.invoice.mapper;

import com.invoice.entity.Company;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface CompanyMapper {
    @Select("select * from company where company_username=#{username}")
    Company getCompanyByName(String username);
}
