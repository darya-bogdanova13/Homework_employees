package Service;


import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.homework.employee.Employee;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static java.util.Collections.min;
import static java.util.Locale.filter;

@Service
public abstract class DeptServiceImpl implements DeptService {
    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee findEmployeeWithMinSalaryFromDept(int dept) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDept() == dept)
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Employee findEmployeeWithMaxSalaryFromDept(int dept) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDept() == dept)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }
    @Override
    public List<Employee> getAllEmployees(int dept) {
        return employees.values()
                .stream()
                .filter(employee -> employee.getDept() == dept)
                .toList();
    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeesGroupedByDept() {
        return employees.values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDept));
    }
}