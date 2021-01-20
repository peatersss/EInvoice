package com.invoice.mapper;

import com.invoice.entity.Detail;
import com.invoice.entity.Invoice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DetailMapper {
    @Select("select * from detail where invoice_id=#{invoice_id}")
    List<Detail> getDetailById(Integer invoice_id);
    @Insert("insert into detail(detail_id, name,count, price,amount, taxRate, taxAmount,invoice_id) values (#{detail_id}, #{name}, #{count}, #{price}, #{amount}, #{taxRate}, #{taxAmount}, #{invoice_id})")
    Integer addDetail(Detail detail);
}
