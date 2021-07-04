package com.example.employeesalaryapp.controllers;

import com.example.employeesalaryapp.models.dto.EmpSalaryToUpdateAndView;
import com.example.employeesalaryapp.models.dto.EmployeeDto;
import com.example.employeesalaryapp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/selectAllEmployees") // Вытаскиваю всех сотрудников с актуальной зарплатой
    public List<EmpSalaryToUpdateAndView> allEmployees(){
        return employeeService.selectAllEmployees();
    }

    @DeleteMapping("/deactivate/{emp_id}")
    public EmployeeDto deactivateEmployee(@PathVariable Long emp_id){
        return employeeService.deactivateEmployee(emp_id);
    }
}
