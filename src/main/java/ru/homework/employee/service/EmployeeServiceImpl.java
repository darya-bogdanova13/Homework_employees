package ru.homework.employee.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.homework.employee.model.Employee;
import ru.homework.employee.exception.EmployeeAlreadyAddedException;
import ru.homework.employee.exception.EmployeeNotFoundException;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();

    @PostConstruct
    public void init() {
        employees.put("Сотрудник 1", new Employee("Вадим", "Безрукавый", 1, 50000));
        employees.put("Сотрудник 2", new Employee("Алексей", "Коток", 2, 90000));
        employees.put("Сотрудник 3", new Employee("Константин", "Реунов", 3, 70000));
        employees.put("Сотрудник 4", new Employee("Андрей", "Постов", 4, 60000));
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int dept) {
        String key = getKey(firstName, lastName);
        if (employees.containsKey(key)){
            throw new EmployeeAlreadyAddedException();
        }
        Employee employee = new Employee(firstName, lastName, dept, salary);
        employees.put(key, employee);
        return employee;
    }

    @Override
    public Employee remove(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)){
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employees.remove(key);
    }

    @Override
    public Employee find(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        if (!employees.containsKey(key)){
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return employees.get(key);
    }

    @Override
    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }
    private String getKey(String firstName, String lastName) {
        return firstName+lastName;
    }
}