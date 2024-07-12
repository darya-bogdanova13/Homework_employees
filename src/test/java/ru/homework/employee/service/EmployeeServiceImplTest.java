package ru.homework.employee.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.homework.employee.exception.EmployeeAlreadyAddedException;
import ru.homework.employee.exception.EmployeeNotFoundException;
import ru.homework.employee.exception.EmployeeStorageIsFullException;
import ru.homework.employee.model.Employee;

public class EmployeeServiceImplTest {
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void clear() {
        employeeService = new EmployeeServiceImpl();
    }
    @Test
    public void shouldCorrectlyAddEmployee(){
        Employee expectedEmployee = new Employee("Вадим", "Безрукавый", 50000, 1);


        Employee actualEmployee = employeeService.add(
                expectedEmployee.getFirstName(),
                expectedEmployee.getLastName(),
                expectedEmployee.getSalary(),
                expectedEmployee.getDept()
        );

        Assertions.assertEquals(expectedEmployee,actualEmployee);

    }
    @Test
    public void shouldTrowEmployeeAlreadyAddedExceptionWhenSuchEmployeeIsAlreadyPresented(){

        employeeService.add("Вадим", "Безрукавый", 50000, 1);

        Assertions.assertThrows(
                EmployeeAlreadyAddedException.class,
                () -> employeeService.add("Вадим", "Безрукавый", 50000, 1)
        );
    }
    @Test
    public void shouldThrowEmployeeAlreadyAddedExceptionWhenStorageFull(){
        int EMPLOYEES_STORAGE_SIZE = 5;
        for (int i = 0; i < EMPLOYEES_STORAGE_SIZE; i++) {
            employeeService.add("Вадим" + i, "Безрукавый", 50000, 1);
        }

        Assertions.assertThrows(
               EmployeeStorageIsFullException.class,
                ()-> employeeService.add("Вадим", "Безрукавый", 50000, 1)
        );
    }
    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenThereIsNoSuchEmployeeDuringRemoving() {

        Assertions.assertThrows(
                EmployeeNotFoundException.class,
                () -> employeeService.remove("Вадим", "Безрукавый")
        );
    }
    @Test
    public void shouldThrowEmployeeNotFoundExceptionWhenThereIsNoSuchEmployeeDuringFinding() {

        Assertions.assertThrows(
                EmployeeNotFoundException.class,
                () ->   employeeService.find("Вадим", "Безрукавый")
        );
    }
    @Test
    public void shouldFindEmployee() {
        Employee employee = new Employee("Вадим", "Безрукавый", 50000, 1);


        Employee expectedEmployee = employeeService.add(
                "Вадим", "Безрукавый", 50000, 1
        );
        Employee actualEmployee = employeeService.find(expectedEmployee.getFirstName(), expectedEmployee.getLastName());
        Assertions.assertEquals(expectedEmployee, actualEmployee);
    }
}
