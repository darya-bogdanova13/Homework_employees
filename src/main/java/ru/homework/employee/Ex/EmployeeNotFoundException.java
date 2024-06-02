package ru.homework.employee.Ex;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Employee is not found")
public class EmployeeNotFoundException extends  RuntimeException {
    public EmployeeNotFoundException(String notFound) {
        super(notFound);
        System.out.println("Employee is not found");
    }
}