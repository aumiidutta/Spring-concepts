package com.poly.controller;

import com.poly.entity.Employee;
import com.poly.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController{
    private final EmployeeService serv;
    public EmployeeController(EmployeeService serv) {
        super();
        this.serv = serv;
    }
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee emp){
        Employee newlyCreatedEmp=serv.createEmployee(emp);
        return ResponseEntity.status(HttpStatus.CREATED).body(newlyCreatedEmp);
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees(){
        List<Employee> list=serv.getAllEmployees();
        return ResponseEntity.status(200).body(list);
    }
}