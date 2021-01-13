package com.invoice.entity;


import org.springframework.stereotype.Repository;


import java.util.Date;

@Repository
public class Auditing {

  private Integer auditing_id;

  private Date auditing_date;
  private Integer department_id;
  private Integer status;
  private String comment;

  public Integer getAuditing_id() {
    return auditing_id;
  }

  public void setAuditing_id(Integer auditing_id) {
    this.auditing_id = auditing_id;
  }

  public Integer getDepartment_id() {
    return department_id;
  }

  public void setDepartment_id(Integer department_id) {
    this.department_id = department_id;
  }

  public Date getAuditing_date() {
    return auditing_date;
  }

  public void setAuditing_date(Date auditing_date) {
    this.auditing_date = auditing_date;
  }




  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
