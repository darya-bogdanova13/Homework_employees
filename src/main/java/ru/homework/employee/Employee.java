package ru.homework.employee;
import java.util.Objects;

public class Employee {
    private final String fistName;
    private final String lastName;
    private int dept;
    private final int salary;


    public Employee(String fistName, String lastName, int dept, int salary) {
        this.fistName = fistName;
        this.lastName = lastName;
        this.dept = dept;
        this.salary = salary;
    }

    public String getFistName() {
        return fistName;
    }
    public int getDept() {
        return dept;
    }

    public int getSalary() {
        return salary;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return fistName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(fistName, employee.fistName) && Objects.equals(lastName, employee.lastName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(fistName, lastName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dept=" + dept +
                ", salary=" + salary +
                '}';
    }
    public void setDept (int dept) {
        this.dept =dept;
    }
}