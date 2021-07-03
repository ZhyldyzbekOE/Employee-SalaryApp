package com.example.employeesalaryapp.mappers;

import com.example.employeesalaryapp.models.Salary;
import com.example.employeesalaryapp.models.dto.EmpSalaryDto;
import com.example.employeesalaryapp.models.dto.EmployeeDto;
import com.example.employeesalaryapp.models.dto.SalaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SalaryMapper {

    SalaryMapper INSTANCE = Mappers.getMapper(SalaryMapper.class);

    Salary toSalary(SalaryDto salaryDto);
    SalaryDto toSalaryDto(Salary salary);

    List<Salary> toSalaries(List<SalaryDto> salaryDtos);
    List<SalaryDto> toSalaryDtos(List<Salary> salaries);
}
