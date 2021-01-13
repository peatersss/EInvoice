package com.invoice.service.ServiceImpl;

import com.invoice.entity.Lgrecord;
import com.invoice.mapper.LgrecordMapper;
import com.invoice.service.LgrecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LgrecordServiceImpl implements LgrecordService {
    @Autowired
    private LgrecordMapper lgrecordMapper;
    @Override
    public void insertLgrecord(Lgrecord lgrecord) {
        lgrecordMapper.insertLgrecord(lgrecord);
    }
}
