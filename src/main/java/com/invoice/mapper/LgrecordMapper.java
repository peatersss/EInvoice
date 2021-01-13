package com.invoice.mapper;

import com.invoice.entity.Lgrecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LgrecordMapper {
    @Insert("insert into lgrecord(departmentId,createDate,ip,browser,os) values(#{departmentId},#{createDate},#{ip},#{browser},#{os})")
    void insertLgrecord(Lgrecord lgrecord);
}
