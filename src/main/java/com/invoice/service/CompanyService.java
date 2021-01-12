package com.invoice.service;

import com.invoice.entity.Company;

public interface CompanyService {
    Company getCompanyByUserName(String username);
}
