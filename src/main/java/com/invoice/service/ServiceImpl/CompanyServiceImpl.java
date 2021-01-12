package com.invoice.service.ServiceImpl;

import com.invoice.entity.Company;
import com.invoice.mapper.CompanyMapper;
import com.invoice.service.CompanyService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    private CompanyMapper companyMapper;


    @Override
    public Company getCompanyByUserName(String username) {
        return null;
    }
}
