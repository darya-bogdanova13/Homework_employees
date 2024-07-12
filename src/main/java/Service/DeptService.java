package Service;

import org.springframework.stereotype.Service;
import ru.homework.employee.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DeptService {
    Employee findEmployeeWithMinSalaryFromDept(int dept);

    Employee findEmployeeWithMaxSalaryFromDept(int dept);

    List<Employee> getAllEmployees(int dept);

    Map<Integer, List<Employee>> getAllEmployeesGroupedByDept();

    void add(String firstName, String lastName, int salary, int dept);
}
