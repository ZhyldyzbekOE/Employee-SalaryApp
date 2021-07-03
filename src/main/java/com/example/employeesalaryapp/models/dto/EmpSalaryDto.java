package com.example.employeesalaryapp.models.dto;

import lombok.Data;

@Data
public class EmpSalaryDto {
    private Long id;
    private String name;
    private String surname;
    private double salary;
}
