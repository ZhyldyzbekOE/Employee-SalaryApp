package com.example.employeesalaryapp.services.impl;

import com.example.employeesalaryapp.dao.EmployeeRepository;
import com.example.employeesalaryapp.exceptions.ClientNotFoundById;
import com.example.employeesalaryapp.mappers.EmployeeMapper;
import com.example.employeesalaryapp.models.Employee;
import com.example.employeesalaryapp.models.Salary;
import com.example.employeesalaryapp.models.dto.EmpSalaryToUpdateAndView;
import com.example.employeesalaryapp.models.dto.EmployeeDto;
import com.example.employeesalaryapp.services.EmployeeService;
import com.example.employeesalaryapp.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SalaryService salaryService;

    @Override
    public EmployeeDto saveNewEmployee(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.INSTANCE.toEmployee(employeeDto);
        employee.setActive(true);
        employeeRepository.save(employee);
        return EmployeeMapper.INSTANCE.toEmployeeDto(employee);
    }

    @Override
    public EmployeeDto existEmployeeById(EmployeeDto employeeDto) {
        Employee employee = EmployeeMapper.INSTANCE.toEmployee(employeeDto);
        if (employeeRepository.existsById(employee.getEmpId())){
            Employee employeeFromDb = employeeRepository.findById(employee.getEmpId()).get();
            EmployeeDto employeeDto1 = EmployeeMapper.INSTANCE.toEmployeeDto(employeeFromDb);
            employeeDto1.setName(employeeDto.getName());
            Employee employee1 = employeeRepository.save(EmployeeMapper.INSTANCE.toEmployee(employeeDto1));
            return EmployeeMapper.INSTANCE.toEmployeeDto(employee1);
        }
        throw new ClientNotFoundById("Пользователь по данному Id не найден. Введите корректные данный!");
    }

    @Override
    public List<EmpSalaryToUpdateAndView> selectAllEmployees() {
        List<Salary> salaries = salaryService.allCurrentRowsFromSalaries();
        for (Salary s : salaries) {
            System.out.println(s);
        };
        List<EmpSalaryToUpdateAndView> empSalaryToUpdateAndViewList = salaries.stream()
                .map(x -> {
                    EmpSalaryToUpdateAndView empSalaryToUpdateAndView = new EmpSalaryToUpdateAndView();
                    empSalaryToUpdateAndView.setEmpId(x.getEmployee().getEmpId());
                    empSalaryToUpdateAndView.setName(x.getEmployee().getName());
                    empSalaryToUpdateAndView.setSalary(x.getSalary());
                    return empSalaryToUpdateAndView;
                })
                .collect(Collectors.toList());
        return empSalaryToUpdateAndViewList;
    }
}
