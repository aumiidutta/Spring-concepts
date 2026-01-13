# JDBC JPA PRODUCT APPLICATION

This project is about showcasing Dynamic Polymorphism that an application can have both Jdbc \& Jpa templates and application.yaml file decides which template to choose.

The application is on **Product** and came in weekly assessment 4.

It can insert, get and delete products, currently running on port 8081 with the endpoint '/product'.



## Challenge faced(if any)

In the application.yaml file, I had to include 
```
session:
  jdbc:
    initialize-schema: always
```