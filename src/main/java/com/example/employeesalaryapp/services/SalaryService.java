package com.example.employeesalaryapp.services;

import com.example.employeesalaryapp.models.Salary;
import com.example.employeesalaryapp.models.dto.EmpSalaryDto;
import com.example.employeesalaryapp.models.dto.EmpSalaryToUpdateAndView;

import java.util.List;

public interface SalaryService {

    EmpSalaryDto creatEmployeeAndSalary(EmpSalaryDto empSalaryDto);

    EmpSalaryToUpdateAndView updateSalary(EmpSalaryToUpdateAndView empSalaryToUpdateAndView);

    List<Salary> allCurrentRowsFromSalaries();
}
