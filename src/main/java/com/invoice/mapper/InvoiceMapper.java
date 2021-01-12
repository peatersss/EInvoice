package com.invoice.mapper;

import com.invoice.entity.Invoice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface InvoiceMapper {
    @Select("select * from invoice where invoice_status=#{status}")
    List<Invoice> getAllInvoice(Integer status);

}
