package com.invoice.service.ServiceImpl;

import com.invoice.entity.Detail;
import com.invoice.mapper.DetailMapper;
import com.invoice.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailServiceImpl implements DetailService {
    @Autowired
    private DetailMapper detailMapper;
    @Override
    public List<Detail> getDetailById(Integer invoice_id) {
        return detailMapper.getDetailById(invoice_id);
    }

    @Override
    public Integer addDetail(Detail detail) {
        return detailMapper.addDetail(detail);
    }
}
