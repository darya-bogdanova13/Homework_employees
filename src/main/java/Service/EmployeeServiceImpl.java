package Service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.homework.employee.Employee;
import ru.homework.employee.Ex.EmployeeAlreadyAddedException;
import ru.homework.employee.Ex.EmployeeNotFoundException;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employees = new HashMap<>();
@PostConstruct
public void init() {
    employees.put("Сотрудник 1", new Employee("Вадим", "Безрукавый",1, 50000));
    employees.put("Сотрудник 2", new Employee("Алексей", "Коток", 2, 90000));
    employees.put("Сотрудник 3", new Employee( "Константин", "Реунов", 3, 70000));
    employees.put("Сотрудник 4", new Employee("Андрей", "Постов", 4, 60000));
}
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
                .min(Comparator.comparing(Employee::getSalary))
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