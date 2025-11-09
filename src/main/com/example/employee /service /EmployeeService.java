package com.example.employee.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.model.Employee;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;
    public EmployeeService(EmployeeRepository repo) { this.repo = repo; }

    public List<Employee> listAll() { return repo.findAll(); }
    public Employee save(Employee e) { return repo.save(e); }
    public void delete(Long id) { repo.deleteById(id); }
    public Employee get(Long id) { return repo.findById(id).orElse(null); }
    public List<Employee> byDepartment(String name) { return repo.findByDepartmentName(name); }
    public List<Employee> joinedAfter(LocalDate date) { return repo.findByJoiningDateAfter(date); }
}
