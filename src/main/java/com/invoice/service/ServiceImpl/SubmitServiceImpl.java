package com.invoice.service.ServiceImpl;

import com.invoice.entity.Submit;
import com.invoice.mapper.SubmitMapper;
import com.invoice.service.SubmitService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmitServiceImpl implements SubmitService {
    @Autowired
    private SubmitMapper submitMapper;
    @Override
    public   Integer addSubmit(Submit submit) {
        return submitMapper.addSubmit(submit);
    }

    @Override
    public List<Submit> getAllSubmitByDepartment(Integer department_id) {
        return submitMapper.getAllSubmitByDepartment(department_id);
    }


}
