package com.invoice.controller;

import com.invoice.entity.Department;
import com.invoice.entity.Submit;
import com.invoice.service.SubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;

@Controller
@RequestMapping("/submit")
public class SubmitController {
    @Autowired
    private SubmitService submitService;
    @PostMapping("/add")
    public String addSubmit(HttpSession session,Double sum, String reason){
        Submit submit=new Submit();
        Department department=(Department)session.getAttribute("department");
        submit.setDepartment_id(department.getDepartment_id());
        submit.setReason(reason);
        submit.setSubmit_date(new Date());
        submit.setSum(sum);
        submitService.addSubmit(submit);
        Integer sid=submit.getSubmit_id();
        return "index";
    }
}
