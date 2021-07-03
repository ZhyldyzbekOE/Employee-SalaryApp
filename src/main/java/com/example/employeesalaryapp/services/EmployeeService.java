package com.example.employeesalaryapp.services;

import com.example.employeesalaryapp.models.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveNewEmployee(EmployeeDto employeeDto);
}
