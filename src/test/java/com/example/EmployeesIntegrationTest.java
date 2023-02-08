package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeesIntegrationTest {

    EmployeeRepository employeeRepository= new EmployeeRepositoryImplementation();
    BankService bankService= new BankServiceImplementation();
    private final Employees employees= new Employees(employeeRepository,bankService);


    @Test
    void payEmployees() {
        employeeRepository.save(new Employee("1",20000));
        employeeRepository.save(new Employee("2",20000));
        employeeRepository.save(new Employee("3",200000));
        int numbersOfPayments =employees.payEmployees();
        assertEquals(3,numbersOfPayments);
    }
    @Test
    void testIfNoEmployees(){
        int numberOfEmployees= employeeRepository.findAll().size();
        assertEquals(0,numberOfEmployees);
    }
    @Test
    void saveOneEmployee(){
        employeeRepository.save(new Employee("1",20000));
        assertEquals(1,employeeRepository.findAll().size());
    }
    @Test
    void findIdForTheFirstInIndex(){
        employeeRepository.save(new Employee("1",20000));
        employeeRepository.save(new Employee("2",20000));
        employeeRepository.save(new Employee("3",200000));
        assertEquals("1",employeeRepository.findAll().get(0).getId());
    }
    @Test
    void willOverWriteOneOfTheEmployees(){
        employeeRepository.save(new Employee("1",2000));
        employeeRepository.save(new Employee("1",3000));
        assertEquals(1,employeeRepository.findAll().size());
    }



}
