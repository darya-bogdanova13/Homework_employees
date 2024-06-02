package ru.homework.employee.Cont;

import Service.DeptService;
import Service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.homework.employee.Employee;

@RestController
@RequestMapping ("/dept")

public class DeptController {
    private final DeptService service;
    public DeptController(DeptService service) {
    this.service = service;
    }

    @GetMapping ("/all")
    public ResponseEntity<?> getAllDept(@RequestParam(required = false) Integer dept) {
        return dept == null ?
                ResponseEntity.ok(service.getAll()):
                ResponseEntity.ok((service.getAllDept(dept)));
    }

    @GetMapping("/maxSalary")
    public Employee getMaxSalary(@RequestParam Integer dept) {
        return service.getMaxSalary(dept);
    }

    @GetMapping("/minSalary")
    public Employee getMinSalary(@RequestParam Integer dept) {
        return service.getMinSalary(dept);
    }
}