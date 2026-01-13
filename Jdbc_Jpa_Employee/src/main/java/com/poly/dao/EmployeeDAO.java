package com.poly.dao;
import com.poly.entity.Employee;
import com.poly.mapper.EmployeeRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeDAO{
    private final JdbcTemplate jt;
    private final String SQL_INSERT="insert into employee(name, salary) values(?, ?)";
    private final String SQL_SELECT="select * from employee where id=?";
    private final String SQL_SELECT_ALL="select * from employee";
    public EmployeeDAO(JdbcTemplate jt) {
        super();
        this.jt = jt;
    }
    public Employee createEmployee(Employee emp) {
        jt.update(SQL_INSERT, emp.getName(), emp.getSalary());
        Integer newId= jt.queryForObject("select last_insert_id()",Integer.class);
        return getEmployee(newId);
    }
    public Employee getEmployee(int id) {
        return jt.queryForObject(SQL_SELECT, new EmployeeRowMapper(), id);
    }
    public List<Employee> getAllEmployees(){
        return jt.query(SQL_SELECT_ALL, new EmployeeRowMapper());
    }
}