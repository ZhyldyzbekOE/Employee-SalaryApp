package com.example.employeesalaryapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ClientNotFoundById extends RuntimeException{

    public ClientNotFoundById(String message) {
        super(message);
    }
}
