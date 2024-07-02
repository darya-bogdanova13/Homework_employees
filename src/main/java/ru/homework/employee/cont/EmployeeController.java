package ru.homework.employee.cont;

import ru.homework.employee.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.homework.employee.model.Employee;

import java.util.Collection;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName,
                                @RequestParam String lastName,
                                @RequestParam int salary,
                                @RequestParam int dept) {
        return service.add(firstName, lastName, salary, dept);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName,
                                   @RequestParam String lastName) {
        return service.remove(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName,
                                 @RequestParam String lastName) {
        return service.find(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> findAllEmployee() {
        return service.findAll();
    }
}