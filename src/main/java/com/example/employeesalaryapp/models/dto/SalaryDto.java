package com.example.employeesalaryapp.models.dto;

import lombok.Data;

import java.util.Date;

@Data
public class SalaryDto {
    private Long id;
    private double salary;
    private Date start_date;
    private Date end_date;
    private EmployeeDto employee;
}
