package com.example.employee.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private LocalDate joiningDate;
    private String designation;

    @ManyToOne
    private Department department;

    public Employee() {}

    public Employee(String name, String email, LocalDate joiningDate, Department department, String designation) {
        this.name = name;
        this.email = email;
        this.joiningDate = joiningDate;
        this.department = department;
        this.designation = designation;
    }

    // getters and setters
    public Long getId() { return id; }
    public String getName() { return name; } public void setName(String name) { this.name = name; }
    public String getEmail() { return email; } public void setEmail(String email) { this.email = email; }
    public LocalDate getJoiningDate() { return joiningDate; } public void setJoiningDate(LocalDate joiningDate) { this.joiningDate = joiningDate; }
    public Department getDepartment() { return department; } public void setDepartment(Department department) { this.department = department; }
    public String getDesignation() { return designation; } public void setDesignation(String designation) { this.designation = designation; }
}
