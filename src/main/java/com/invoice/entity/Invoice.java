package com.invoice.entity;


import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class Invoice {

  private Integer invoice_id;
  private String invoice_code;//发票代码
  private String invoice_number;//发票号码
  private Date invoice_date;//创建日期
  private String buyer_name;
  private String buyer_code;
  private String seller_name;
  private String seller_code;
  private String service_name;//服务名称
  private double price;
  private Integer amount;
  private double tax_rate;
  private double tax_amount;
  private Integer invoice_status;
  private String invoice_type;
  private Integer department_id;
  private Integer submit_id;
  private Integer auditing_id;

  public String getFileUrl() {
    return fileUrl;
  }

  public void setFileUrl(String fileUrl) {
    this.fileUrl = fileUrl;
  }

  private String fileUrl;

  public Integer getSubmit_id() {
    return submit_id;
  }

  public void setSubmit_id(Integer submit_id) {
    this.submit_id = submit_id;
  }

  public Integer getAuditing_id() {
    return auditing_id;
  }

  public void setAuditing_id(Integer auditing_id) {
    this.auditing_id = auditing_id;
  }



  public String getInvoice_code() {
    return invoice_code;
  }

  public void setInvoice_code(String invoice_code) {
    this.invoice_code = invoice_code;
  }

  public String getInvoice_number() {
    return invoice_number;
  }

  public void setInvoice_number(String invoice_number) {
    this.invoice_number = invoice_number;
  }

  public Date getInvoice_date() {
    return invoice_date;
  }

  public void setInvoice_date(Date invoice_date) {
    this.invoice_date = invoice_date;
  }

  public String getBuyer_name() {
    return buyer_name;
  }

  public void setBuyer_name(String buyer_name) {
    this.buyer_name = buyer_name;
  }

  public String getBuyer_code() {
    return buyer_code;
  }

  public void setBuyer_code(String buyer_code) {
    this.buyer_code = buyer_code;
  }

  public String getSeller_name() {
    return seller_name;
  }

  public void setSeller_name(String seller_name) {
    this.seller_name = seller_name;
  }

  public String getSeller_code() {
    return seller_code;
  }

  public void setSeller_code(String seller_code) {
    this.seller_code = seller_code;
  }

  public String getService_name() {
    return service_name;
  }

  public void setService_name(String service_name) {
    this.service_name = service_name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public Integer getInvoice_id() {
    return invoice_id;
  }

  public void setInvoice_id(Integer invoice_id) {
    this.invoice_id = invoice_id;
  }

  public Integer getAmount() {
    return amount;
  }

  public void setAmount(Integer amount) {
    this.amount = amount;
  }

  public double getTax_rate() {
    return tax_rate;
  }

  public void setTax_rate(double tax_rate) {
    this.tax_rate = tax_rate;
  }

  public double getTax_amount() {
    return tax_amount;
  }

  public void setTax_amount(double tax_amount) {
    this.tax_amount = tax_amount;
  }

  public Integer getInvoice_status() {
    return invoice_status;
  }

  public void setInvoice_status(Integer invoice_status) {
    this.invoice_status = invoice_status;
  }

  public String getInvoice_type() {
    return invoice_type;
  }

  public void setInvoice_type(String invoice_type) {
    this.invoice_type = invoice_type;
  }

  public Integer getDepartment_id() {
    return department_id;
  }

  public void setDepartment_id(Integer department_id) {
    this.department_id = department_id;
  }

  @Override
  public String toString() {
    return "Invoice{" +
            "invoice_id=" + invoice_id +
            ", invoice_code='" + invoice_code + '\'' +
            ", invoice_number='" + invoice_number + '\'' +
            ", invoice_date=" + invoice_date +
            ", buyer_name='" + buyer_name + '\'' +
            ", buyer_code='" + buyer_code + '\'' +
            ", seller_name='" + seller_name + '\'' +
            ", seller_code='" + seller_code + '\'' +
            ", service_name='" + service_name + '\'' +
            ", price=" + price +
            ", amount=" + amount +
            ", tax_rate=" + tax_rate +
            ", tax_amount=" + tax_amount +
            ", invoice_status=" + invoice_status +
            ", invoice_type='" + invoice_type + '\'' +
            ", department_id=" + department_id +
            ", submit_id=" + submit_id +
            ", auditing_id=" + auditing_id +
            ", fileUrl='" + fileUrl + '\'' +
            '}';
  }
}
