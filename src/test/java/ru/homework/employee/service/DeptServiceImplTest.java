package ru.homework.employee.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.homework.employee.model.Employee;

import java.util.*;

@ExtendWith(MockitoExtension.class)
public class DeptServiceImplTest {

    private final List<Employee> employeeList = new ArrayList<>() {{
        add(new Employee("Вадим", "Безрукавый", 2, 50000));
        add(new Employee("Алексей", "Корников",2, 90000));
        add(new Employee("Алексей", "Коток", 1, 70000));
        add(new Employee("Андрей", "Постов", 2, 60000));
        add(new Employee("Чугунов", "Сергей", 3, 70000));
    }};
    private final Map<String, Employee> employees = new HashMap<>();

    @BeforeEach
    public void initMap() {
        for (Employee employee : employeeList) {
            employees.put(employee.getFirstName() + employee.getLastName(), employee);
            
        }
    }


    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DeptServiceImpl deptService;

    @Test
    public void shouldGetAll() {

        Integer dept = 1;
        Mockito.when(employeeService.findAll()).thenReturn();

        List<Employee> expectedEmployees = List.of(employeeList.get(0), employeeList.get(1), employeeList.get(2));
        List<Employee> actualEmployees = deptService.getAll(dept);

        Assertions
                .assertThat(actualEmployees)
                .containsExactlyInAnyOrderElementsOf(expectedEmployees);
    }
    @Test
    public void shouldSalarySum() {

        Integer dept = 1;
        Mockito.when(employeeService.findAll()).thenReturn();

        List<Employee> expectedEmployees = List.of(employeeList.get(0), employeeList.get(1), employeeList.get(2));
        Integer actualSalarySum = deptService.getAll(dept);

        Assertions
                .assertThat(actualEmployees)
                .containsExactlyInAnyOrderElementsOf(expectedEmployees);
    }
}
