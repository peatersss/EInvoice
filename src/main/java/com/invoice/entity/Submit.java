package com.invoice.entity;


import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class Submit {
  private long submitId;

  private Date submitDate;
  private long departmentId;
  private String reason;
  public long getSubmitId() {
    return submitId;
  }

  public void setSubmitId(long submitId) {
    this.submitId = submitId;
  }





  public Date getSubmitDate() {
    return submitDate;
  }

  public void setSubmitDate(java.sql.Timestamp submitDate) {
    this.submitDate = submitDate;
  }


  public long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(long departmentId) {
    this.departmentId = departmentId;
  }


  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

}
