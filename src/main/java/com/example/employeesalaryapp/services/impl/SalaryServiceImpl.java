package com.example.employeesalaryapp.services.impl;

import com.example.employeesalaryapp.dao.SalaryRepository;
import com.example.employeesalaryapp.mappers.EmpSalMapper;
import com.example.employeesalaryapp.mappers.EmpSalaryToUpdateAndViewMapper;
import com.example.employeesalaryapp.mappers.EmployeeMapper;
import com.example.employeesalaryapp.mappers.SalaryMapper;
import com.example.employeesalaryapp.models.Employee;
import com.example.employeesalaryapp.models.Salary;
import com.example.employeesalaryapp.models.dto.EmpSalaryDto;
import com.example.employeesalaryapp.models.dto.EmpSalaryToUpdateAndView;
import com.example.employeesalaryapp.models.dto.EmployeeDto;
import com.example.employeesalaryapp.models.dto.SalaryDto;
import com.example.employeesalaryapp.services.EmployeeService;
import com.example.employeesalaryapp.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

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

        Salary salaryToSave = save(salaryDto, employeeDto);
        EmpSalaryDto empSalaryDto1 = new EmpSalaryDto();
        empSalaryDto1.setSalary(salaryToSave.getSalary());
        empSalaryDto1.setName(salaryToSave.getEmployee().getName());
        return empSalaryDto1;
    }

    private Salary save(SalaryDto salaryDto, EmployeeDto employeeDto){
        salaryDto.setEmployee(employeeDto);
        salaryDto.setStart_date(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2999);
        calendar.set(Calendar.DAY_OF_MONTH, 31);
        calendar.set(Calendar.MONTH, 11);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        Date date = calendar.getTime();
        salaryDto.setEnd_date(date);
        Salary salaryToSave = salaryRepository.save(SalaryMapper.INSTANCE.toSalary(salaryDto));
        return salaryToSave;
    }

    @Override
    public EmpSalaryToUpdateAndView updateSalary(EmpSalaryToUpdateAndView empSalaryToUpdateAndView) {

        Employee employee = EmpSalaryToUpdateAndViewMapper.INSTANCE.toEmployee(empSalaryToUpdateAndView);
        Salary salary = EmpSalaryToUpdateAndViewMapper.INSTANCE.toSalary(empSalaryToUpdateAndView);
        EmployeeDto employeeDto = employeeService.existEmployeeById(EmployeeMapper.INSTANCE.toEmployeeDto(employee));

        Salary salaries = salaryRepository.findSalaryByEmployeeIdAndCurrentSalaryBetweenSysdate(employeeDto.getEmpId());
        if (salaries.getSalary() == empSalaryToUpdateAndView.getSalary()){
            return empSalaryToUpdateAndView; // если зарплаты совпали, то возвращаю объект без сохранения
        }else {
            Date date;
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.SECOND, -1);
            date = calendar.getTime();
            salaries.setEnd_date(date);
            salaryRepository.save(salaries);
        }

        SalaryDto salaryDto = SalaryMapper.INSTANCE.toSalaryDto(salary);
        Salary salary1 = save(salaryDto, employeeDto);
        EmpSalaryToUpdateAndView empSalaryToUpdateAndView1 = new EmpSalaryToUpdateAndView();
        empSalaryToUpdateAndView1.setEmpId(salary1.getEmployee().getEmpId());
        empSalaryToUpdateAndView1.setName(salary1.getEmployee().getName());
        empSalaryToUpdateAndView1.setSalary(salary1.getSalary());
        return empSalaryToUpdateAndView1;
    }

}
