package Service;

import org.springframework.stereotype.Service;
import ru.homework.employee.Employee;
import ru.homework.employee.Ex.EmployeeAlreadyAddedException;
import ru.homework.employee.Ex.EmployeeNotFoundException;

import java.util.*;

@Service
public abstract class EmployeeServiceImpl implements EmployeeService {
    private final int STORAGE_SIZE = 5;
    private final Map<String, Employee> employees;
    public EmployeeServiceImpl() {
        this.employees = new HashMap<>();
    }
    private List<Employee> employeeList;
    public List<Employee> getEmployeeList() {
        return employeeList;
    }
    public Map<String, Employee> getEmployees() {
        return employees;
    }
    public EmployeeServiceImpl(Map<String, Employee> employees) {
        this.employees = employees;
    }
    public EmployeeServiceImpl(Map<String, Employee> employees, List<Employee> employeeList) {
        this.employees = employees;
        this.employeeList = employeeList;
    }
    @Override
    public Employee findEmployeeWithMaxSalaryFromDept(String firstName, String lastName, int salary, int department) {
        return null;
    }
    @Override
    public Employee findEmployeeWithMinSalaryFromDept(String firstName, String lastName, int salary, int department) {
        return null;
    }
    @Override
    public Employee add (String firstName, String lastName, int dept, int salary) {
        Employee employee = new Employee(firstName, lastName, dept, salary);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }
    @Override
    public Employee remove(String firstName, String lastName, int dept, int salary) {
        Employee employee = new Employee(firstName, lastName, dept, salary);
        if (employees.containsKey(employee.getFullName())) {
            employees.remove(employee);
            return employee;
        }
        throw new EmployeeNotFoundException(" ");
    }
    @Override
    public Employee find(String firstName, String lastName, int dept, int salary){
        Employee employee = new Employee(firstName, lastName, dept, salary);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundException(" ");
    }
    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
    @Override
    public Collection<Employee> findEmployeeWithMaxSalaryFromDept() {
        return null;
    }
    @Override
    public Collection<Employee> findEmployeeWithMinSalaryFromDept(){
        return null;
    }
    @Override
    public List<Employee> list() {
        return null;
    }
    @Override
    public Employee remove(String firstName, String lastName) {
        return null;
    }
    @Override
    public Employee find(String firstName, String lastName) {
        return null;
    }
}

