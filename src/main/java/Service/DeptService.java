package Service;

import ru.homework.employee.Employee;

import java.util.List;
import java.util.Map;

public interface DeptService {
    List <Employee> getEmployees(int i);

    Map<Integer, List <Employee>> getAll();

    List<Employee> findEmployeesFromDept(int dept);
    Map<Integer, List<Employee>> groupEmployeesByDept();

    Employee findEmployeeWithMinSalaryFromDepartment(int dept);

    Employee findEmployeeWithMinSalaryFromDept(int dept);
    Employee findEmployeeWithMaxSalaryFromDept(int dept);

}

