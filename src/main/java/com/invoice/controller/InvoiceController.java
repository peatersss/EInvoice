package com.invoice.controller;

import com.invoice.Result.Result;
import com.invoice.Result.ResultFactory;
import com.invoice.Util.FileUtil;
import com.invoice.Util.InvoiceExtractor;
import com.invoice.entity.Department;
import com.invoice.entity.Detail;
import com.invoice.entity.Invoice;
import com.invoice.service.DetailService;
import com.invoice.service.InvoiceService;
import org.apache.commons.io.FileUtils;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.awt.datatransfer.DataTransferer;
import org.apache.http.HttpEntity;
import javax.servlet.http.HttpSession;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
@Controller
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private DetailService detailService;
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
        Invoice invoice=invoiceService.getInvoiceById(invoice_id);
        List<Detail> details=detailService.getDetailById(invoice_id);
        invoice.setDetailList(details);
        return ResultFactory.buidResult(200,null,invoice);
    }
    @PostMapping(value = "/upload")
    @ResponseBody
    public Result extrat(HttpSession session,MultipartFile file, String url) {
        String fileName=file.getOriginalFilename();
        System.out.println(fileName);
        String filePath= FileUtil.getUpLoadFilePath();
        fileName=System.currentTimeMillis()+fileName;
        System.out.println(fileName);
        try {
            FileUtil.uploadFile(file.getBytes(),filePath,fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Invoice result = null;
        try {
            try {
                Department department=(Department)session.getAttribute("department");
                result = InvoiceExtractor.extract(new File(filePath+"/"+fileName));
                result.setFile_url(filePath+"/"+fileName);
                result.setDepartment_id(department.getDepartment_id());
                result.setInvoice_status(0);
                invoiceService.addInvoice(result);
                Integer id=result.getInvoice_id();
                for(Detail detail:result.getDetailList()){
                    detail.setInvoice_id(id);
                    detailService.addDetail(detail);
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            result = new Invoice();
        }
        return ResultFactory.buildSuccessResult(result);
    }
}
