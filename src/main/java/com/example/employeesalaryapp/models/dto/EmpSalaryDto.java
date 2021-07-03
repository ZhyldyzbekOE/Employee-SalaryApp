package com.example.employeesalaryapp.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class EmpSalaryDto {
    @JsonIgnore
    private Long id;
    private String name;
    private double salary;
}
