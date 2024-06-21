package ru.homework.employee.Cont;

import Service.DeptService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.homework.employee.Employee;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class DeptController {

    private final DeptService deptService;

    public DeptController(DeptService deptService) {
        this.deptService = deptService;
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeWithMinSalaryFromDept(int deptId) {
        return deptService.findEmployeeWithMinSalaryFromDept(deptId);
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalaryFromDept(int deptId) {
        return deptService.findEmployeeWithMaxSalaryFromDept(deptId);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees(int deptId) {
        return deptService.getAllEmployees(deptId);
    }

    @GetMapping("/all-gr")
    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDept() {
        return deptService.getAllEmployeesGroupedByDept();
    }
}