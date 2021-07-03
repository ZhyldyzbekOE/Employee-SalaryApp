package com.example.employeesalaryapp.services.impl;

import com.example.employeesalaryapp.dao.EmployeeRepository;
import com.example.employeesalaryapp.mappers.EmployeeMapper;
import com.example.employeesalaryapp.models.Employee;
import com.example.employeesalaryapp.models.dto.EmployeeDto;
import com.example.employeesalaryapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveNewEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.INSTANCE.toEmployee(employeeDto);
        employee.setActive(true);
        employeeRepository.save(employee);
        return EmployeeMapper.INSTANCE.toEmployeeDto(employee);
    }
}
