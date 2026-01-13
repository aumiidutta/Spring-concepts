# JDBC JPA EMPLOYEE APPLICATION

This project is about showcasing Dynamic Polymorphism that an application can have both Jdbc & Jpa templates and application.yaml file decides which template to choose.

The application is on Product and came in weekly assessment 4.

It can insert and getAll employee details, currently running on port 8082 with the endpoint '/employees'.


## Challenge faced(if any)

In the application.yaml file, I had to include 
```
jpa:
  hibernate:
    ddl-auto: update
      properties:
        dialect: org.hibernate.dialect.MySQLDialect
        show-sql: true
```