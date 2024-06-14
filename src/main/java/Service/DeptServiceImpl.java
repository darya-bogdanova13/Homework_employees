package Service;


import org.springframework.stereotype.Service;
import ru.homework.employee.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static java.util.Collections.min;
import static java.util.Locale.filter;

@Service
public class DeptServiceImpl implements DeptService {
    private final EmployeeService employeeServiceImpl;

    public DeptServiceImpl(EmployeeService employeeServiceImpl) {

        this.employeeServiceImpl = employeeServiceImpl;
    }
    public List<Employee> findEmployeesFromDepartment (int dept) {
        return employeeServiceImpl.findAll()
                .stream()
                .filter(employee -> employee.getDept() == dept)
                .collect(Collectors.toList());
    }
    public Map <String, Employee> employees;
    public Map<Integer, List<Employee>>  groupEmployeesByDepartment() {
        return null;
    }
    @Override
    public Employee findEmployeeWithMinSalaryFromDepartment(int dept) {
        return employeeServiceImpl.findEmployeeWithMaxSalaryFromDept()
                .stream()
                .filter(employee -> employee.getDept() == dept)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow();
    }
    @Override
    public Employee findEmployeeWithMinSalaryFromDept(int dept) {
        return employeeServiceImpl.findEmployeeWithMinSalaryFromDept()
                .stream()
                .filter(employee -> employee.getDept() == dept)
                .min(Comparator.comparing(Employee::getSalary))
                .orElseThrow();
    }

    @Override
    public List <Employee> getEmployees(int i) {
        return null;
    }
    @Override
    public Map<Integer, List <Employee>> getAll() {
        return employeeServiceImpl.findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDept));
    }

    @Override
    public List<Employee> findEmployeesFromDept(int dept) {
        return null;
    }

    @Override
    public Map<Integer, List<Employee>> groupEmployeesByDept() {
        return null;
    }


    @Override
    public Employee findEmployeeWithMaxSalaryFromDept(int dept) {
        return null;
    }
}
