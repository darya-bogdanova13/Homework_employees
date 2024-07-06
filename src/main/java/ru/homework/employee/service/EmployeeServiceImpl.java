package ru.homework.employee.service;

import jakarta.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ru.homework.employee.exception.EmployeeAlreadyAddedException;
import ru.homework.employee.exception.EmployeeNotFoundException;
import ru.homework.employee.exception.createEmployeeException;
import ru.homework.employee.model.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();
    @PostConstruct
    public void init() {
        employees.put("Сотрудник 1", new Employee("Вадим", "Безрукавый", 50000, 1));
        employees.put("Сотрудник 2", new Employee("Алексей", "Корников",90000, 2));
        employees.put("Сотрудник 3", new Employee("Константин", "Реунов", 70000, 3));
        employees.put("Сотрудник 4", new Employee("Андрей", "Постов", 60000, 4));
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int dept) {
        String key = getKey(firstName, lastName);
        if (employees.containsKey(key)) {
            throw new EmployeeAlreadyAddedException();
        }
        createEmployee(firstName, lastName);
        Employee employee = new Employee(firstName, lastName, dept, salary);
        employees.put(key, employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        createEmployee(firstName, lastName);
        return employees.remove(key);
    }

    @Override
    public Employee find(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        createEmployee(firstName, lastName);
        return employees.get(key);
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }

    private String getKey(String firstName, String lastName) {
        return firstName + lastName;
    }

    @GetMapping("/createEmployee")
    private void createEmployee(String firstName, String lastName) {
        if (!(StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName))) {
            throw new createEmployeeException();
        }
    }
}