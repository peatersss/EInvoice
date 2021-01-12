package com.invoice.entity;


import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Repository
public class Auditing {

  private long auditingId;

  private Date auditingDate;
  private long departmentId;
  private long status;
  private String comment;


  public long getAuditingId() {
    return auditingId;
  }

  public void setAuditingId(long auditingId) {
    this.auditingId = auditingId;
  }





  public Date getAuditingDate() {
    return auditingDate;
  }

  public void setAuditingDate(Date auditingDate) {
    this.auditingDate = auditingDate;
  }


  public long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(long departmentId) {
    this.departmentId = departmentId;
  }


  public long getStatus() {
    return status;
  }

  public void setStatus(long status) {
    this.status = status;
  }


  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

}
