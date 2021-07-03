package com.example.employeesalaryapp.services.impl;

import com.example.employeesalaryapp.dao.SalaryRepository;
import com.example.employeesalaryapp.mappers.EmpSalMapper;
import com.example.employeesalaryapp.mappers.EmployeeMapper;
import com.example.employeesalaryapp.mappers.SalaryMapper;
import com.example.employeesalaryapp.models.Employee;
import com.example.employeesalaryapp.models.Salary;
import com.example.employeesalaryapp.models.dto.EmpSalaryDto;
import com.example.employeesalaryapp.models.dto.EmployeeDto;
import com.example.employeesalaryapp.models.dto.SalaryDto;
import com.example.employeesalaryapp.services.EmployeeService;
import com.example.employeesalaryapp.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public EmpSalaryDto creatEmployeeAndSalary(EmpSalaryDto empSalaryDto) {

        Employee employee = EmpSalMapper.INSTANCE.toEmployee(empSalaryDto);
        Salary salary = EmpSalMapper.INSTANCE.toSalary(empSalaryDto);

        EmployeeDto employeeDto =  employeeService.saveNewEmployee(EmployeeMapper.INSTANCE.toEmployeeDto(employee));
        SalaryDto salaryDto = SalaryMapper.INSTANCE.toSalaryDto(salary);

        salaryDto.setEmployee(employeeDto);
        salaryDto.setStart_date(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2999); calendar.set(Calendar.DAY_OF_MONTH, 31);
        calendar.set(Calendar.MONTH, 11);  calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59); calendar.set(Calendar.SECOND, 59);
        Date date = calendar.getTime();
        salaryDto.setEnd_date(date);
        Salary salaryToSave = salaryRepository.save(SalaryMapper.INSTANCE.toSalary(salaryDto));
        EmpSalaryDto empSalaryDto1 = new EmpSalaryDto();
        empSalaryDto1.setSalary(salaryToSave.getSalary());
        empSalaryDto1.setName(salaryToSave.getEmployee().getName());
        return empSalaryDto1;
    }
}
