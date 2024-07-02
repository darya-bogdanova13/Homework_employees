package ru.homework.employee.service;

import ru.homework.employee.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee add(String firstName, String lastName, int salary, int dept);

    Employee remove(String firstName, String lastName);

    Employee find(String firstName, String lastName);

    List<Employee> findAll();
}

