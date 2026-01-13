package com.poly.service.impl;

import com.poly.entity.Employee;
import com.poly.repository.EmployeeRepository;
import com.poly.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("jpa")
public class JpaEmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repo;
    public JpaEmployeeServiceImpl(EmployeeRepository repo) {
        super();
        this.repo = repo;
    }
    @Override
    public Employee createEmployee(Employee emp) {
        return repo.save(emp);// the entity will be inserted PK auto generated
    }
    @Override
    public List<Employee> getAllEmployees() {
        System.out.println("getAllEmployees() with JpaRepository");
        return repo.findAll();
    }
}