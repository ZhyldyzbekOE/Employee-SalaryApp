package com.example.employeesalaryapp.mappers;

import com.example.employeesalaryapp.models.Employee;
import com.example.employeesalaryapp.models.dto.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee toEmployee(EmployeeDto employeeDto);
    EmployeeDto toEmployeeDto(Employee employee);

    List<Employee> toEmployees(List<EmployeeDto> employeeDtos);
    List<EmployeeDto> toEmployeeDtos(List<Employee> employees);

}
