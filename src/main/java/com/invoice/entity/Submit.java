package com.invoice.entity;


import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class Submit {
  private Integer submit_id;

  private Date submit_date;
  private Integer department_id;
  private String reason;
  private Double sum;
  private String departmentName;

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }

  public Double getSum() {
    return sum;
  }

  public void setSum(Double sum) {
    this.sum = sum;
  }


  public Integer getSubmit_id() {
    return submit_id;
  }

  public void setSubmit_id(Integer submit_id) {
    this.submit_id = submit_id;
  }

  public Date getSubmit_date() {
    return submit_date;
  }

  public void setSubmit_date(Date submit_date) {
    this.submit_date = submit_date;
  }

  public Integer getDepartment_id() {
    return department_id;
  }

  public void setDepartment_id(Integer department_id) {
    this.department_id = department_id;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

}
