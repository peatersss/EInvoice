package com.invoice.controller;

import com.invoice.Result.Result;
import com.invoice.Result.ResultFactory;
import com.invoice.entity.Department;
import com.invoice.entity.Invoice;
import com.invoice.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.awt.datatransfer.DataTransferer;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @GetMapping("/getSubmitInvoice")
    @ResponseBody
    public Result getAllInvoiceByStatus(HttpSession session, Integer submit_id){
        Department department=(Department)session.getAttribute("department");
        List<Invoice> list=invoiceService.getSubmitInvoiceByDepartmentId(department.getDepartment_id(),submit_id);
        return ResultFactory.buidResult(200,"",list);
    }

    @GetMapping("/getInvoiceFold")
    @ResponseBody
    public Result getInvoiceFold(Model model,HttpSession session){
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
        return ResultFactory.buidResult(200,"",map);
    }
    @GetMapping("/detail")
    @ResponseBody
    public Result getDetail(Model model,Integer invoice_id){
        return ResultFactory.buidResult(200,null,invoiceService.getInvoiceById(invoice_id));
    }

}
