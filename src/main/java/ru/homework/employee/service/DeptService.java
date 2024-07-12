package ru.homework.employee.service;

import org.springframework.context.annotation.ComponentScan;
import ru.homework.employee.model.Employee;

import java.util.List;
import java.util.Map;

@ComponentScan
public interface DeptService {
    Employee findEmployeeWithMinSalaryFromDept(int dept);

    Employee findEmployeeWithMaxSalaryFromDept(int dept);

    List<Employee> getAll(int dept);

    Map<Integer, List<Employee>> getAllGroupedByDept();

    int getSalary(int dept);

}
