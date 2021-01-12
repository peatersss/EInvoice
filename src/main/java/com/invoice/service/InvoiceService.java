package com.invoice.service;

import com.invoice.entity.Invoice;

import java.util.List;
public interface InvoiceService {
    //管理员查询对应状态的发票
    List<Invoice> getAllInvoice(Integer status);
/**
     //根据提交id查找对应的发票，用于部门和管理
     List<Invoice> getAllInvoiceBySubmitId(Integer submit_id);
     //根据审核id查找发票，用于部门和管理
     List<Invoice> getAllInvoiceByAuditingId(Integer auditing_id);
     //提交后更改对应发票的状态
     void setSubmitInvoice(Integer invoice_id);
     //添加发票
     void  addInvoice(Invoice invoice);
     //根据发票id查询
     Invoice getInvoiceById(Integer invoice_id);
     //查找部门各种状态的发票
     List<Invoice> getAllInvoiceByDepartmentId(Integer department_id,Integer status);

**/
}
