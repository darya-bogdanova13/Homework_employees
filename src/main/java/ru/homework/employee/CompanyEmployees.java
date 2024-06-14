package ru.homework.employee;

import Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

@Component
public class CompanyEmployees implements CommandLineRunner {
  @Autowired
  private EmployeeService employeeService;

    public CompanyEmployees(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
      employeeService.add("Вадим", " Безрукавый", 50000, 1 );
              employeeService.add("Алексей", " Коток", 90000, 2);
              employeeService.add("Константин", " Реунов", 70000, 3);
              employeeService.add("Андрей", " Постов", 60000, 4);
  }
}
