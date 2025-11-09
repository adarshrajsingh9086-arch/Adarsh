package com.example.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.employee.model.Department;
import com.example.employee.model.Employee;
import com.example.employee.repository.DepartmentRepository;
import com.example.employee.repository.EmployeeRepository;

import java.time.LocalDate;

@SpringBootApplication
public class EmployeeManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner init(EmployeeRepository employeeRepo, DepartmentRepository deptRepo) {
        return args -> {
            Department hr = new Department("HR");
            Department it = new Department("IT");
            deptRepo.save(hr);
            deptRepo.save(it);

            employeeRepo.save(new Employee("Alice", "alice@example.com", LocalDate.of(2020,5,10), hr, "HR Manager"));
            employeeRepo.save(new Employee("Bob", "bob@example.com", LocalDate.of(2021,3,15), it, "Developer"));
        };
    }
}
