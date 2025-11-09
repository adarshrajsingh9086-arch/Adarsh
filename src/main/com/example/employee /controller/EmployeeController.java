package com.example.employee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.employee.model.Employee;
import com.example.employee.model.Department;
import com.example.employee.repository.DepartmentRepository;
import com.example.employee.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;
    private final DepartmentRepository deptRepo;

    public EmployeeController(EmployeeService service, DepartmentRepository deptRepo) {
        this.service = service;
        this.deptRepo = deptRepo;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("employees", service.listAll());
        return "employees/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("departments", deptRepo.findAll());
        return "employees/form";
    }

    @PostMapping
    public String save(@ModelAttribute Employee employee, @RequestParam(value="deptId", required=false) Long deptId) {
        if (deptId != null) {
            Department d = deptRepo.findById(deptId).orElse(null);
            employee.setDepartment(d);
        }
        service.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("employee", service.get(id));
        model.addAttribute("departments", deptRepo.findAll());
        return "employees/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/employees";
    }

    @GetMapping("/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("employee", service.get(id));
        return "employees/view";
    }
}
