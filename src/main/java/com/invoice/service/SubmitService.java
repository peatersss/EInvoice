package com.invoice.service;

import com.invoice.entity.Submit;

import java.util.List;

public interface SubmitService {
    Integer addSubmit(Submit submit);
    List<Submit> getAllSubmitByDepartment(Integer department_id);
    List<Submit> getAllSubmit();
    Submit getSubmitById();
}
