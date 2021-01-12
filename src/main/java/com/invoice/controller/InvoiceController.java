package com.invoice.controller;

import com.invoice.entity.Invoice;
import com.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @PostMapping("/list")
    public String getAllInvoiceByStatus(){
        List<Invoice> list=invoiceService.getAllInvoice(0);
        System.out.println(list.get(0));
        return "";
    }
}
