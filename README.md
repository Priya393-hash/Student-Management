# Student Management System

## About the Project

Student Management System is a backend application developed using Java and Spring Boot. It provides REST APIs to manage student information and perform database operations using MySQL.

The application follows a layered architecture to separate different responsibilities and make the code easier to maintain.

**Project Status:** In Progress 🚧

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman

## Features

- Add new student records.
- Retrieve student information.
- Search students by ID.
- Update existing student records.
- Delete student records.
- Store student information in MySQL.
- Validate incoming requests.
- Handle exceptions using custom exception handling.
- Return appropriate HTTP error responses.

## Student Information

The Student entity contains the following attributes:

| Field | Description |
|---|---|
| id | Unique student ID |
| name | Student name |
| skill | Student skill |
| age | Student age |
| email | Student email |

## Project Architecture

The project follows a layered architecture.

```text
Client (Postman)
       |
       v
Controller Layer
       |
       v
Service Layer
       |
       v
Repository Layer
       |
       v
Spring Data JPA
       |
       v
Hibernate
       |
       v
MySQL Database
```

## Project Structure

```text
src/main/java/com/example/demo
│
├── controller
│
├── service
│
├── repository
│
├── entity
│
├── dto
│
└── exception
```

## Exception Handling

The application uses custom exception handling to manage errors.

- StudentNotFoundException
- GlobalExceptionHandler
- ErrorResponse
- @RestControllerAdvice
- @ExceptionHandler

Appropriate HTTP status codes are returned when errors occur.

## Validation

Input validation is implemented using Jakarta Bean Validation annotations.

Examples:

- @Valid
- @Min

These validations help ensure that incoming student data meets the defined requirements.

## Database

MySQL is used to store student information.

Spring Data JPA and Hibernate are used for database interaction and object-relational mapping.

## API Testing

Postman is used to test the REST APIs and verify application responses.

## Learning Outcomes

Through this project, I am gaining practical experience in:

- Developing REST APIs using Spring Boot.
- Understanding layered architecture.
- Database connectivity using MySQL.
- Working with Spring Data JPA and Hibernate.
- Implementing DTOs.
- Input validation and exception handling.
- Handling HTTP responses and status codes.

## Future Improvements

- Improve API documentation.
- Enhance application functionality.
- Continue improving backend architecture.

---

**Project Status:** Currently under development.
