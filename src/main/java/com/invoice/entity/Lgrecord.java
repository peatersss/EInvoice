package com.invoice.entity;


import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class Lgrecord {

  private long recordId;
  private long departmentId;
  private Date createDate;
  private String ip;
  private String browser;
  private String os;


  public long getRecordId() {
    return recordId;
  }

  public void setRecordId(long recordId) {
    this.recordId = recordId;
  }


  public long getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(long departmentId) {
    this.departmentId = departmentId;
  }


  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }


  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }


  public String getBrowser() {
    return browser;
  }

  public void setBrowser(String browser) {
    this.browser = browser;
  }


  public String getOs() {
    return os;
  }

  public void setOs(String os) {
    this.os = os;
  }

}
