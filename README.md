# Student Management REST API

## Overview

This project provides a RESTful API for managing student data, including their grades, using Java Spring Boot. The API allows for creating and updating student records while calculating average grades for each course.

## Table of Contents

- [Features](#features)
- [Technologies](#technologies)
- [API Endpoints](#api-endpoints)
- [Data Models](#data-models)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)

## Features

- Create and update student records.
- Store and manage grades associated with each student.
- Calculate and store average grades for courses with multiple entries.

## Technologies

- **Java 17**: The programming language used for backend development.
- **Spring Boot**: A framework for building production-ready applications quickly and easily.
- **JPA (Java Persistence API)**: For managing relational data in Java applications.
- **H2 Database**: An in-memory database for development and testing.

## API Endpoints

### 1. Create Student

- **URL**: `/students`
- **Method**: `POST`
- **Request Body**: 
  ```json
  {
      "name": "John Doe",
      "stdNumber": "12345",
      "grades": [
          {
              "code": "MATH101",
              "value": 85
          },
          {
              "code": "ENG102",
              "value": 90
          }
      ]
  }
## Response

### Create Student

- **201 Created**: Returns the created student object.
  ```json
  {
      "id": 1,
      "name": "John Doe",
      "stdNumber": "12345",
      "grades": [
          {
              "id": 1,
              "code": "MATH101",
              "value": 85
          },
          {
              "id": 2,
              "code": "ENG102",
              "value": 90
          }
      ]
  }

### Update Student

- **URL**: `/students/{stdNumber}`
- **Method**: `PUT`
- **Path Variable**: `stdNumber`
- **Request Body**: 
  ```json
  {
      "name": "John Doe Updated",
      "grades": [
          {
              "code": "MATH101",
              "value": 88
          }
      ]
  }

### Response

- **200 OK**: Returns the updated student object.
  ```json
  {
      "id": 1,
      "name": "John Doe Updated",
      "stdNumber": "12345",
      "grades": [
          {
              "id": 1,
              "code": "MATH101",
              "value": 88
          }
      ]
  }
404 Not Found: If the student with the given student number does not exist.

500 Internal Server Error: If an error occurs during the process.

## Data Models


### Grade And Student

@Entity
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String code;
    private int value;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}



```java
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String stdNumber;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Grade> grades;
}
````

## Installation

1. Repository'yi klonlayın:
   ```bash
   git clone https://github.com/yourusername/zyferaassignment.git
2.Proje dizinine gidin:
   ```bash
  cd zyferaassignment
 ```
3.Maven ile projeyi oluşturun:
  ```bash
 mvn clean install
 ```
Uygulamayı çalıştırın:
  ```bash
mvn spring-boot:run
 ```

## Usage

To interact with the API endpoints, you can use tools like Postman or curl. The application runs at `http://localhost:8082`.

## Contributing

Contributions are welcome! If you have suggestions or improvements, feel free to open an issue or submit a pull request.
