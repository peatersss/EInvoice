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
}
