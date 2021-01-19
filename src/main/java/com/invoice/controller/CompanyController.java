package com.invoice.controller;

import com.invoice.Result.Result;
import com.invoice.Result.ResultFactory;
import com.invoice.entity.Company;
import com.invoice.entity.Submit;
import com.invoice.service.CompanyService;
import com.invoice.service.DepartmentService;
import com.invoice.service.InvoiceService;
import com.invoice.service.SubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private SubmitService submitService;
    @Autowired
    private DepartmentService departmentService;
    @PostMapping(value = "/login")
    @ResponseBody
    public Result dologin(HttpSession session, Model model, @RequestParam("usr")String username, @RequestParam("pwd")String password) {
        Company company=companyService.getCompanyByUserName(username);
        Map<String,Object> map=new HashMap<String,Object>();
        if(company==null){
            return  ResultFactory.buildFailResult("该用户不存在");
        }
        if(!company.getCompany_password().equals(password)){
            return  ResultFactory.buildFailResult("用户名或者密码错误");
        }
        session.setAttribute("company",company);
        return ResultFactory.buildSuccessResult(null);
    }
    @GetMapping("/index")
    public Result index(HttpSession session){
        List<Submit> submitList=submitService.getAllSubmit();
        HashMap<String,Object> map=new HashMap<>();
        for(Submit submit:submitList){
            Integer did=submit.getDepartment_id();
            submit.setDepartmentName(departmentService.getDepartmentById(did).getDepartment_name());
        }
        map.put("submitList",submitList);
        map.put("number",submitList.size());

        return ResultFactory.buildSuccessResult(map);
    }
}
