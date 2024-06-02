package Service;

import ru.homework.employee.Employee;

import java.util.List;
import java.util.Map;

public interface DeptService {
    public List <Employee> getAllDept (int dept);
    public Map <Integer, List <Employee>> getAll(int dept);
    List <Employee> getEmployees (int i);
    Map<Integer, List<Employee>> getAll();

    Employee getMaxSalary (int dept);

    Employee getMinSalary (int dept);

}

