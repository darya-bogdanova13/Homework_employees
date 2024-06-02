package Service;


import org.springframework.stereotype.Service;
import ru.homework.employee.Employee;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DeptServiceImpl implements DeptService {
    private final EmployeeServiceImpl employeeServiceImpl;

    public DeptServiceImpl(EmployeeService employeeServiceImpl) {

        this.employeeServiceImpl = (EmployeeServiceImpl) employeeServiceImpl;
    }
    public List<Employee> getAllDept (int dept) {
        return employeeServiceImpl.findAll()
                .stream()
                .filter(employee -> employee.getDept() == dept)
                .collect(Collectors.toList());
    }
    public Map <String, Employee> employees;
    @Override
    public Map<Integer, List<Employee>> getAll(int dep) {
        return null;
    }
    @Override
    public Employee getMaxSalary(int dept) {
        return employeeServiceImpl.getEmployees().values()
                .stream()
                .filter(employee -> employee.getDept() == dept)
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow();
    }
    @Override
    public Employee getMinSalary(int dept) {
        return employeeServiceImpl.getEmployees().values()
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
}
