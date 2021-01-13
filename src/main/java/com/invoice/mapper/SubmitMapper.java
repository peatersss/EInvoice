package com.invoice.mapper;

import com.invoice.entity.Submit;
import org.apache.ibatis.annotations.*;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface SubmitMapper {
    @Select("select * from submit where department_id=#{department_id}")
    List<Submit> getAllSubmitByDepartment(Integer department_id);

    @Insert("INSERT INTO submit(submit_date,department_id,reason,sum)  values(#{submit_date},#{department_id},#{reason},#{sum})")
    @Options(useGeneratedKeys = true,keyProperty = "submit_id")
    Integer addSubmit(Submit submit);

    @Delete("delete from submit where submit_id=#{submit_id}")
    void deleteSubmit(Integer submit_id);

}
