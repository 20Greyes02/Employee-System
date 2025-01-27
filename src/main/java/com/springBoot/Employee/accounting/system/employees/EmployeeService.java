package com.springBoot.Employee.accounting.system.employees;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {

        if (employeeRepository.findByEmail(employee.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email is already taken");
        }
        if (employee.getSalary() <= 5000) {
            throw new IllegalArgumentException("Salary must be bigger then 5.000");
        }
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        if (employeeRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Employee not found by id=%s".formatted(id));
        }
        employeeRepository.deleteById(id);
    }

    @Transactional
    public void updateEmployee(Long id, String email, Integer salary) {
        var employeeToUpdate = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not fount"));
        if (email != null && !email.isEmpty() && !email.equals(employeeToUpdate.getEmail())) {
            Optional<Employee> employeeOpt = employeeRepository.findByEmail(email);
            if (employeeOpt.isPresent()) {
                throw new IllegalArgumentException("Email already taken");
            }
            employeeToUpdate.setEmail(email);
        }
        if (salary != null) {
            if (salary <= 5000) {
                throw new IllegalArgumentException("Salary must be bigger then 5.000");
            }
            employeeToUpdate.setSalary(salary);
        }
    }
}