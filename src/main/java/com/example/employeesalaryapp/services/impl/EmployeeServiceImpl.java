package com.example.employeesalaryapp.services.impl;

import com.example.employeesalaryapp.dao.EmployeeRepository;
import com.example.employeesalaryapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

}
