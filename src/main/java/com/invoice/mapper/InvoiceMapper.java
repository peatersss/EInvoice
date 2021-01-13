package com.invoice.mapper;

import com.invoice.entity.Invoice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface InvoiceMapper {
    @Select("select * from invoice where invoice_id=#{invoice_id}")
    Invoice getInvoiceById(Integer invoice_id);

    @Select("select * from invoice where invoice_status=#{status}")
    List<Invoice> getAllInvoice(Integer status);


    @Select("select ei.* from invoice ei join submit on ei.submit_id=submit.submit_id where submit.department_id=#{department_id} and submit_id = #{submit_id}")
    List<Invoice> getSubmitInvoiceByDepartmentId(Integer department_id,Integer submit_id);


    @Select("select ei.* from invoice ei join auditing on ei.auditing_id=auditing.auditing_id where auditing.department_id=#{department_id} and auditing_id = #{auditing_id}")
    List<Invoice> getAllAuditingInvoiceByDepartmentId(Integer department_id,Integer auditing_id);
    @Select("select ei.* from invoice ei join auditing on ei.auditing_id=auditing.auditing_id where auditing.department_id=#{department_id} and ei.invoice_status=2 and auditing_id = #{auditing_id}")
    List<Invoice> getAllAuditingPassInvoiceByDepartmentId(Integer department_id,Integer auditing_id);
    @Select("select ei.* from invoice ei join auditing on ei.auditing_id=auditing.auditing_id where auditing.department_id=#{department_id} and ei.invoice_status=3 and auditing_id = #{auditing_id}")
    List<Invoice> getAllAuditingNotPassInvoiceByDepartmentId(Integer department_id,Integer auditing_id);

    @Select("select * from invoice where invoice_status=0 and department_id =#{department_id}")
    List<Invoice> getAllNotSubmit(Integer department_id);

    @Update("update invoice set invoice_status=#{status} where invoice_id=#{invoice_id}")
    List<Invoice> updateStatus(Integer status,Integer invoice_id);

    @Insert("insert into invoice(invoice_code, invoice_number, invoice_date, buyer_name, buyer_code, seller_name, seller_code, service_name, price, amount, tax_rate, tax_amount, invoice_status, invoice_type, department_id, submit_id, auditing_id, file_url) values (#{invoice_code}, #{invoice_number}, #{invoice_date}, #{buyer_name}, #{buyer_code}, #{seller_name}, #{seller_code}, #{service_name}, #{price}, #{amount}, #{tax_rate}, #{tax_amount}, #{invoice_status}, #{invoice_type}, #{department_id}, #{submit_id}, #{auditing_id}, #{file_url})")
    void addInvoice(Invoice invoice);

}
