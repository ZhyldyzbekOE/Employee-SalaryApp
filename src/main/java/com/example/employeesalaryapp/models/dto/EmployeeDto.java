package com.example.employeesalaryapp.models.dto;

import lombok.Data;

@Data
public class EmployeeDto {

    private Long EmpId;
    private String name;
    private boolean active;

}
