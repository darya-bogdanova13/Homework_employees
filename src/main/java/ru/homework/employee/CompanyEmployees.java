package ru.homework.employee;

import Service.DeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;


@Component
public class CompanyEmployees implements CommandLineRunner {
  @Autowired
  private DeptService deptService;

    @Override
    public void run(String... args) throws Exception {
        deptService.add("Вадим", " Безрукавый", 50000, 1 );
        deptService.add("Алексей", " Коток", 90000, 2);
        deptService.add("Константин", " Реунов", 70000, 3);
        deptService.add("Андрей", " Постов", 60000, 4);
  }
}
