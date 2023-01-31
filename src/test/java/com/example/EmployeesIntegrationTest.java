package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeesIntegrationTest {

    EmployeeRepository employeeRepository= new EmployeeRepositoryImplementation();
    BankService bankService= Mockito.mock(BankService.class);
    private final Employees employees= new Employees(employeeRepository,bankService);

    @BeforeEach
    void setup(){
        employeeRepository.save(new Employee("1",20000));
        employeeRepository.save(new Employee("2",20000));
        employeeRepository.save(new Employee("3",200000));
    }
    @Test
    void payEmployees() {
        int numbersOfPayments =employees.payEmployees();
        assertEquals(3,numbersOfPayments);
    }
}
