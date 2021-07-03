package com.example.employeesalaryapp.mappers;

import com.example.employeesalaryapp.models.Salary;
import com.example.employeesalaryapp.models.dto.SalaryDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface SalaryMapper {

    Salary toSalary(SalaryDto salaryDto);
    SalaryDto toSalaryDto(Salary salary);

    List<Salary> toSalaries(List<SalaryDto> salaryDtos);
    List<SalaryDto> toSalaryDtos(List<Salary> salaries);
}
