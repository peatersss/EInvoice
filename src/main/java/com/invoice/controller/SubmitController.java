package com.invoice.controller;

import com.invoice.Result.Result;
import com.invoice.Result.ResultFactory;
import com.invoice.entity.Department;
import com.invoice.entity.Submit;
import com.invoice.service.InvoiceService;
import com.invoice.service.SubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/submit")
public class SubmitController {
    @Autowired
    private SubmitService submitService;
    @Autowired
    private InvoiceService invoiceService;
    @PostMapping("/add")
    public Result addSubmit(List<Integer> ids,HttpSession session, Double sum, String reason){
        Submit submit=new Submit();
        Department department=(Department)session.getAttribute("department");
        submit.setDepartment_id(department.getDepartment_id());
        submit.setReason(reason);
        submit.setSubmit_date(new Date());
        submit.setSum(sum);
        submitService.addSubmit(submit);
        Integer sid=submit.getSubmit_id();
        for(Integer id:ids){
            invoiceService.updateStatus1(sid,id);
        }
        return ResultFactory.buildSuccessResult(null);
    }
}
