package com.example.employeesalaryapp.controllers;

import com.example.employeesalaryapp.models.dto.EmpSalaryDto;
import com.example.employeesalaryapp.models.dto.EmpSalaryToUpdateAndView;
import com.example.employeesalaryapp.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @PostMapping("/save")
    public EmpSalaryDto create(@RequestBody EmpSalaryDto empSalaryDto){
        /*
            EmpSalaryDto - это объект который содержит поля с классов: Salary, Employee.
            Далее начинаю делить это объект, уже на два разнях объекта
        * */
        System.out.println(empSalaryDto);
        return salaryService.creatEmployeeAndSalary(empSalaryDto);
    }

    @PutMapping("/updateSalary")
    public EmpSalaryToUpdateAndView updateSalary(@RequestBody EmpSalaryToUpdateAndView empSalaryToUpdateAndView){
        System.out.println("Enter " +empSalaryToUpdateAndView);
        return salaryService.updateSalary(empSalaryToUpdateAndView);
    }

}
