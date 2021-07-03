package com.example.employeesalaryapp.mappers;

import com.example.employeesalaryapp.models.Employee;
import com.example.employeesalaryapp.models.Salary;
import com.example.employeesalaryapp.models.dto.EmpSalaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmpSalMapper {

    EmpSalMapper INSTANCE  = Mappers.getMapper(EmpSalMapper.class);


    Employee toEmployee(EmpSalaryDto empSalaryDto);

    Salary toSalary(EmpSalaryDto empSalaryDto);

    EmpSalaryDto toEmpSalaryDto(Salary salary);

}
