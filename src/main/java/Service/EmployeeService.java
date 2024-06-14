package Service;

import org.springframework.stereotype.Service;
import ru.homework.employee.Employee;

import java.util.Collection;
import java.util.List;
@Service

public interface EmployeeService {
        Employee add(String firstName, String lastName, int dept, int salary);

        Employee remove(String firstName, String lastName, int dept, int salary);

        Employee find(String firstName, String lastName, int dept, int salary);
        Employee findEmployeeWithMaxSalaryFromDept(String firstName, String lastName, int salary, int department);
        Employee findEmployeeWithMinSalaryFromDept(String firstName, String lastName, int salary, int dept);
        Collection<Employee> findAll();
        Collection<Employee> findEmployeeWithMaxSalaryFromDept();
        Collection<Employee> findEmployeeWithMinSalaryFromDept();
        List<Employee> list();
        Employee remove(String firstName, String lastName);
        Employee find(String firstName, String lastName);
}
