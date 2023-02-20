package com.example;

import java.util.*;

public class EmployeeRepositoryImplementation implements EmployeeRepository {

    private List< Employee> employees;

    public EmployeeRepositoryImplementation() {
        this.employees = new LinkedList<>();
    }

    public EmployeeRepositoryImplementation(LinkedList<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee save(Employee e) {
        employees.add(e);
        return e;
    }
}
