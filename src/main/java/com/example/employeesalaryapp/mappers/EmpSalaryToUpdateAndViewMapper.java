package com.example.employeesalaryapp.mappers;

import com.example.employeesalaryapp.models.Employee;
import com.example.employeesalaryapp.models.Salary;
import com.example.employeesalaryapp.models.dto.EmpSalaryToUpdateAndView;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmpSalaryToUpdateAndViewMapper {

    EmpSalaryToUpdateAndViewMapper INSTANCE = Mappers.getMapper(EmpSalaryToUpdateAndViewMapper.class);

    Employee toEmployee(EmpSalaryToUpdateAndView empSalaryToUpdateAndView);

    Salary toSalary(EmpSalaryToUpdateAndView empSalaryToUpdateAndView);
}
