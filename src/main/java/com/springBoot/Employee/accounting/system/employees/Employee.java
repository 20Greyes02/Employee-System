package com.springBoot.Employee.accounting.system.employees;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate birthDate;
    private int salary;
    @Transient
    private int age;

    public Employee() {
    }

    public Employee(Long id, String name, String email, LocalDate birthDate, int salary) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
        this.age = Period.between(birthDate, LocalDate.now()).getYears();
        this.salary = salary;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        if(age == 0){
            this.age = Period.between(birthDate, LocalDate.now()).getYears();
        }
        return age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
