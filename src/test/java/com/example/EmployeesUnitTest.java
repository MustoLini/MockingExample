package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class EmployeesUnitTest {

    EmployeeRepository employeeRepository=mock(EmployeeRepository.class);

    BankService bankService = mock(BankService.class);

    private final Employees employees = new Employees(employeeRepository, bankService);

    Employee employee = mock(Employee.class);
    @Test
    void payEmployees() {
        when(employeeRepository.findAll()).thenReturn(List.of(employee));
        when(employeeRepository.save(any(Employee.class))).then(returnsFirstArg());
        int numbersOfPayments = employees.payEmployees();
        assertEquals(1, numbersOfPayments);
        verify(employee, times(1)).getId();
        verify(employee, times(1)).getSalary();
        verify(employee, times(1)).setPaid(true);
        verify(bankService,times(1));
    }

}