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
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;
    @PostMapping(value = "/login")
    public Map<String,Object> dologin(HttpSession session, Model model, @RequestParam("usr")String username, @RequestParam("pwd")String password) {
        Company company=companyService.getCompanyByUserName(username);
        Map<String,Object> map=new HashMap<String,Object>();
        if(company==null){
            map.put("code",400);
            map.put("msg","该用户不存在");
            return map;
        }
        if(!company.getCompany_password().equals(password)){
            map.put("code",400);
            map.put("msg","账户或者密码输入错误");
            return map;
        }
        session.setAttribute("company",company);
        map.put("code",200);
        return map;
    }
}
