package ru.homework.employee.service;

import ru.homework.employee.model.Employee;

import java.util.List;
import java.util.Map;

public interface DeptService {
    Employee findEmployeeWithMinSalaryFromDept(int dept);

    Employee findEmployeeWithMaxSalaryFromDept(int dept);

    public List<Employee> getAll(int dept);


    Map<Integer, List<Employee>> getAllGroupedByDept();

}
