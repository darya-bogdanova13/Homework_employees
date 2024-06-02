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
        Employee maxSalary(String firstName, String lastName, int salary, int department);
        Employee minSalary(String firstName, String lastName, int salary, int department);
        Collection<Employee> findAll();
        Collection<Employee> maxSalary();
        Collection<Employee> minSalary();
        List<Employee> list();
        void remove(String firstName, String lastName);
        Employee find(String firstName, String lastName);
}
