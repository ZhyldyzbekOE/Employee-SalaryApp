package com.example.employeesalaryapp.services.impl;

import com.example.employeesalaryapp.dao.SalaryRepository;
import com.example.employeesalaryapp.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

}
