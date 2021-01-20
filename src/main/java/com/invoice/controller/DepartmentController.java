package com.invoice.controller;

import com.invoice.DemoApplication;
import com.invoice.Result.Result;
import com.invoice.Result.ResultFactory;
import com.invoice.Util.IpUtil;
import com.invoice.Util.JudgeUtill;
import com.invoice.Util.JwtUtil;
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

    //@GetMapping(value = "/login")
    //public String tologin(){
       // return "department/login";
    //}
    @PostMapping(value = "/login")
    @ResponseBody
    public Result dologin(@RequestBody Map<String, String> loginForm, HttpServletRequest request) {
        String username = loginForm.get("username");
        String password = loginForm.get("password");
        System.out.println("进来了 "+username+password);
        Department department=departmentService.getDepartmentByUserName(username);
        Map<String,Object> map=new HashMap<String,Object>();
        if(department==null){
            return  ResultFactory.buildFailResult("该用户不存在");
        }
        if(!department.getDepartment_password().equals(password)){
            return  ResultFactory.buildFailResult("账户或者密码输入错误");
        }
        String token = JwtUtil.sign(username, password);
        if (token == null) {
            return ResultFactory.buildFailResult("用户token已失效");
        }
        HttpSession session = request.getSession();
        session.setAttribute("department",department);
        //System.out.println((Department)request.getSession().getAttribute("department"));
        String ipadress= IpUtil.getIpAddr(request);
        String browser= JudgeUtill.whatBrower(request.getHeader("USER-AGENT"));
        String os=JudgeUtill.whatOS(request.getHeader("USER-AGENT"));
        Lgrecord lgrecord=new Lgrecord();
        lgrecord.setBrowser(browser);
        lgrecord.setCreateDate(new Date());
        lgrecord.setIp(ipadress);
        lgrecord.setDepartmentId(department.getDepartment_id());
        lgrecordService.insertLgrecord(lgrecord);
        return ResultFactory.buildSuccessResult(token);
    }
    @GetMapping("/index")
    @ResponseBody
    public Result toIndex(HttpServletRequest request ){
        HttpSession session = request.getSession();
        Department department=(Department)session.getAttribute("department");
        List<Submit> submitList=submitService.getAllSubmitByDepartment(department.getDepartment_id());
        return ResultFactory.buidResult(200,"成功",submitList);
    }
}
