package com.poly.service;

import com.poly.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee emp);
    List<Employee> getAllEmployees();
}