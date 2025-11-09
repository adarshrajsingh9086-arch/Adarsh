package com.example.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.employee.model.Employee;
import java.util.List;
import java.time.LocalDate;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByDepartmentName(String name);
    List<Employee> findByJoiningDateAfter(LocalDate date);
}
