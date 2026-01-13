package com.poly.config;

import com.poly.service.EmployeeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource source) {
        return new JdbcTemplate(source);
    }

    @Primary
    @Bean
    public EmployeeService selectService(
            @Qualifier("template") EmployeeService templateService,
            @Qualifier("jpa") EmployeeService jpaService,
            @Value("${app.persistenceType}") String typeOfService) {
        if (typeOfService.equalsIgnoreCase("jpa")) {
            return jpaService;
        } else {
            return templateService;
        }
    }
}