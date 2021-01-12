package com.invoice.entity;

import org.springframework.stereotype.Repository;

@Repository
public class Department {

  private Integer department_id;
  private String department_name;
  private String department_username;
  private String department_password;
  private Integer company_id;

  public Integer getCompany_id() {
    return company_id;
  }

  public void setCompany_id(Integer comapany_id) {
    this.company_id = comapany_id;
  }

  public Integer getDepartment_id() {
    return department_id;
  }

  public void setDepartment_id(Integer department_id) {
    this.department_id = department_id;
  }

  public String getDepartment_name() {
    return department_name;
  }

  public void setDepartment_name(String department_name) {
    this.department_name = department_name;
  }

  public String getDepartment_username() {
    return department_username;
  }

  public void setDepartment_username(String department_username) {
    this.department_username = department_username;
  }

  public String getDepartment_password() {
    return department_password;
  }

  public void setDepartment_password(String department_password) {
    this.department_password = department_password;
  }
}
