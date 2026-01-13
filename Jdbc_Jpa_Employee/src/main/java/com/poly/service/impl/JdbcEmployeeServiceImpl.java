package com.poly.service.impl;

import com.poly.dao.EmployeeDAO;
import com.poly.entity.Employee;
import com.poly.exceptions.EmployeeException;
import com.poly.service.EmployeeService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("template")
public class JdbcEmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO dao;
    public JdbcEmployeeServiceImpl(EmployeeDAO dao) {
        super();
        this.dao = dao;
    }
    public Employee createEmployee(Employee emp) {
        try {
            return dao.createEmployee(emp);
        }
        catch(EmptyResultDataAccessException e) {
            throw new EmployeeException("INSERT FAILURE");
        }
    }
    @Override
    public List<Employee> getAllEmployees() {
        System.out.println("In getAllEmployees() with JdbcTemplate");
        return dao.getAllEmployees();
    }
}