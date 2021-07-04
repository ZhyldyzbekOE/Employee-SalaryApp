package com.example.employeesalaryapp.models.dto;

import lombok.Data;

@Data
public class EmpSalaryToUpdateAndView {
    private Long EmpId;
    private String name;
    private double salary;
}
