package ru.homework.employee.Cont;

import Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.homework.employee.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeWithMinSalaryFromDept(int deptId) {
        return employeeService.findEmployeeWithMinSalaryFromDept(deptId);
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalaryFromDept(int deptId) {
        return employeeService.findEmployeeWithMaxSalaryFromDept(deptId);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees(int deptId) {
        return employeeService.getAllEmployees(deptId);
    }

    @GetMapping("/all-gr")
    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDept() {
        return employeeService.getAllEmployeesGroupedByDept();
    }
}