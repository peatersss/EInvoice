package com.invoice.entity;

import org.springframework.stereotype.Repository;

@Repository
public class Company {

  private Integer company_id;
  private String company_name;
  private String company_username;
  private String company_password;
  private String tax_number;

  public Integer getCompany_id() {
    return company_id;
  }

  public void setCompany_id(Integer company_id) {
    this.company_id = company_id;
  }

  public String getCompany_name() {
    return company_name;
  }

  public void setCompany_name(String company_name) {
    this.company_name = company_name;
  }

  public String getCompany_username() {
    return company_username;
  }

  public void setCompany_username(String company_username) {
    this.company_username = company_username;
  }

  public String getCompany_password() {
    return company_password;
  }

  public void setCompany_password(String company_password) {
    this.company_password = company_password;
  }

  public String getTax_number() {
    return tax_number;
  }

  public void setTax_number(String tax_number) {
    this.tax_number = tax_number;
  }

  @Override
  public String toString() {
    return "Company{" +
            "company_id=" + company_id +
            ", company_name='" + company_name + '\'' +
            ", company_username='" + company_username + '\'' +
            ", company_password='" + company_password + '\'' +
            ", tax_number='" + tax_number + '\'' +
            '}';
  }
}
