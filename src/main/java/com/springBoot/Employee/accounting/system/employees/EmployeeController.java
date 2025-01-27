package com.springBoot.Employee.accounting.system.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping
    public List<Employee> helloWorld(){
        return employeeService.getAllEmployees();
    }
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
       return employeeService.createEmployee(employee);
    }
    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long id){
        employeeService.deleteEmployee(id);
    }
    @PutMapping("/{employeeId}")
    public void updateEmployee(
            @PathVariable("employeeId") Long id,
            @RequestParam(value = "email", required = false)String email,
            @RequestParam(value = "salary", required = false)Integer salary){
        employeeService.updateEmployee(id, email, salary);
    }
}
