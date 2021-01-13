package com.invoice.controller;

import com.invoice.DemoApplication;
import com.invoice.Util.IpUtil;
import com.invoice.Util.JudgeUtill;
import com.invoice.entity.Department;
import com.invoice.entity.Lgrecord;
import com.invoice.entity.Submit;
import com.invoice.mapper.DepartmentMapper;
import com.invoice.service.DepartmentService;
import com.invoice.service.LgrecordService;
import com.invoice.service.SubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private LgrecordService lgrecordService;
    @Autowired
    private SubmitService submitService;
    @GetMapping(value = "/login")
    public String tologin(){
        return "department/login";
    }
    @PostMapping(value = "/login")
    @ResponseBody
    public Map<String,Object> dologin(HttpSession session, HttpServletRequest request, String username, String password) {

        Department department=departmentService.getDepartmentByUserName(username);
        Map<String,Object> map=new HashMap<String,Object>();
        if(department==null){
            map.put("code",400);
            map.put("msg","该用户不存在");
            return map;
        }
        if(!department.getDepartment_password().equals(password)){
            map.put("code",400);
            map.put("msg","账户或者密码输入错误");
            return map;
        }
        session.setAttribute("department",department);
        map.put("code",200);
        String ipadress= IpUtil.getIpAddr(request);
        String browser= JudgeUtill.whatBrower(request.getHeader("USER-AGENT"));
        String os=JudgeUtill.whatOS(request.getHeader("USER-AGENT"));
        Lgrecord lgrecord=new Lgrecord();
        lgrecord.setBrowser(browser);
        lgrecord.setCreateDate(new Date());
        lgrecord.setIp(ipadress);
        lgrecord.setDepartmentId(department.getDepartment_id());
        lgrecordService.insertLgrecord(lgrecord);
        return map;
    }
    @GetMapping("/index")
    public String toIndex(HttpSession session, Model model){
        Department department=(Department)session.getAttribute("department");
        List<Submit> submitList=submitService.getAllSubmitByDepartment(department.getDepartment_id());
        model.addAttribute("submitList",submitList);
        return "department/index";
    }
}
