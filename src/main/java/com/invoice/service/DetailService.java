package com.invoice.service;

import com.invoice.entity.Detail;


import java.util.List;

public interface DetailService {
    List<Detail> getDetailById(Integer invoice_id);
    Integer addDetail(Detail detail);
}
