package com.example;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class EmployeesUnitTest {
    @Mock
    EmployeeRepository employeeRepository;
    @Mock
    BankService bankService;
    private final Employees employees= new Employees(employeeRepository,bankService);
    @Test
    void payEmployees() {

    }
}