package com.invoice.service;

import com.invoice.entity.Submit;

public interface SubmitService {
    void addSubmitRecord(Submit submit);
    Submit getSubmitByDepartmentId(Integer department_id);
    void deleteSubmitById(Integer submit_id);
}
