package com.example.employeesalaryapp.services;

import com.example.employeesalaryapp.models.dto.EmpSalaryToUpdateAndView;
import com.example.employeesalaryapp.models.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto saveNewEmployee(EmployeeDto employeeDto);

    EmployeeDto existEmployeeById(EmployeeDto employeeDto);

    List<EmpSalaryToUpdateAndView> selectAllEmployees();
}
