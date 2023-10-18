# PoseidonInc

## Description
Web application in java for an OpenClassroom project.

## Technical:

1. Spring Boot 3.1.0
2. Java 17
3. Thymeleaf
4. Bootstrap v.4.3.1

### Dependencies

written in the pom.xml:
* spring-boot-starter-data-jpa
* spring-boot-starter-security
* spring-boot-starter-thymeleaf
* spring-boot-starter-web
* thymeleaf-extras-springsecurity6
* mysql-connector-j
* lombok
* spring-boot-starter-test
* spring-security-test
* spring-boot-starter-validation
* h2

### Installing

* The directory of the project is needed.
* MYSQL installed on your computer.
* setting 2 environment variable:
  * Your MYSQL acces rights with the name DATABASE_USERNAME and DATABASE_PASSWORD.
* create empty mysql database called demo with url jdbc:mysql://localhost:3306/demo. You can change the localhost number in the application.properties file if needed.
* In MYSQL after creating the database execute data.sql in database demo.

### Executing program

* going directly to the directory of the poject poseidonInc and use the commandLine:
```
mvn install
mvn spring-boot:run
```
then on the browser of your choice you can use the url  localhost:8080 .
