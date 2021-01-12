package com.invoice.controller;

import com.invoice.entity.Company;
import com.invoice.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @PostMapping(value = "/login")
    public String dologin(HttpSession session,Model model, @RequestParam("usr")String username, @RequestParam("pwd")String password) {
        Company company=companyService.getCompanyByUserName(username);
        if(company==null){
            model.addAttribute("msg","该用户不存在");
            return "company/login";
        }
        if(!company.getCompany_password().equals(password)){
            model.addAttribute("msg","账户或者密码输入错误");
            return "company/login";
        }
        session.setAttribute("company",company);
        return "company/index";
    }
}
