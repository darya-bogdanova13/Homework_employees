package ru.homework.employee.cont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.homework.employee.model.Employee;
import ru.homework.employee.service.DeptService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dept")
public class DeptController {

    private final DeptService service;
    @Autowired
    public DeptController(DeptService service) {
        this.service = service;
    }

    @GetMapping("/min-salary")
    public Employee findEmployeeWithMinSalaryFromDept(@RequestParam int dept) {
        return service.findEmployeeWithMinSalaryFromDept(dept);
    }

    @GetMapping("/max-salary")
    public Employee findEmployeeWithMaxSalaryFromDept(@RequestParam int dept) {
        return service.findEmployeeWithMaxSalaryFromDept(dept);
    }


    @GetMapping(path = "/all", params = "deptId")
    public List<Employee> getAllEmployeesGroupedByDept(@RequestParam int deptId) {
        return service.getAll(deptId);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDept() {
        return service.getAllGroupedByDept();
    }
}