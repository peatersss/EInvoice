package com.invoice.service.ServiceImpl;

import com.invoice.entity.Invoice;
import com.invoice.mapper.InvoiceMapper;
import com.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    private InvoiceMapper invoiceMapper;
    @Override
    public List<Invoice> getAllInvoice(Integer status) {
        return invoiceMapper.getAllInvoice(status);
    }

    @Override
    public List<Invoice> getSubmitInvoiceByDepartmentId(Integer department_id, Integer submit_id) {
        return invoiceMapper.getSubmitInvoiceByDepartmentId(department_id,submit_id);
    }


    @Override
    public List<Invoice> getAllAuditingInvoiceByDepartmentId(Integer department_id,Integer auditing_id) {
        return invoiceMapper.getAllAuditingInvoiceByDepartmentId(department_id,auditing_id);
    }

    @Override
    public List<Invoice> getAllNotSubmit(Integer department_id) {
        return invoiceMapper.getAllNotSubmit(department_id);
    }

    @Override
    public Invoice getInvoiceById(Integer invoice_id) {
        return invoiceMapper.getInvoiceById(invoice_id);
    }


}
