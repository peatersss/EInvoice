package com.invoice.controller;

import com.invoice.entity.Department;
import com.invoice.entity.Invoice;
import com.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.awt.datatransfer.DataTransferer;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @GetMapping("/getSubmitInvoice")
    public String getAllInvoiceByStatus(HttpSession session, Model model,Integer submit_id){
        Department department=(Department)session.getAttribute("department");
        List<Invoice> list=invoiceService.getSubmitInvoiceByDepartmentId(department.getDepartment_id(),submit_id);
        model.addAttribute("invoiceList",list);
        return "";
    }
   // @GetMapping("/")
    @GetMapping("/getInvoiceFold")
    public String getInvoiceFold(Model model,HttpSession session){
        HashMap<String,List<Invoice>> map=new HashMap<String,List<Invoice>>();
        List<Invoice> invoiceList=invoiceService.getAllNotSubmit(((Department)session.getAttribute("department")).getDepartment_id());
        Collections.sort(invoiceList, new Comparator<Invoice>() {
            @Override
            public int compare(Invoice o1, Invoice o2) {
                int flag = o1.getInvoice_date().compareTo(o2.getInvoice_date());
                return flag;
            }
        });
        for(int i=0;i<invoiceList.size();i++){
            Date date=invoiceList.get(i).getInvoice_date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            Integer year=calendar.get(Calendar.YEAR);
            Integer month=calendar.get(Calendar.MONTH);
            String key=year+"-"+month;
            if(!map.containsKey(key)){
                List<Invoice> list=new ArrayList<>();
                list.add(invoiceList.get(i));
                map.put(key,list);
            }else{
                map.get(key).add(invoiceList.get(i));
            }

        }
        return "";
    }
    @GetMapping("/detail")
    public String getDetail(Model model,Integer invoice_id){
        model.addAttribute("invoice",invoiceService.getInvoiceById(invoice_id));
        return "";
    }

}
