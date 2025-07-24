# JWT Authentication Demo Project

This project is a demonstration of implementing JWT (JSON Web Token) authentication with Spring Boot.

## Project Overview

This is a Spring Boot application (`jwt` artifact) designed to showcase how to integrate JWT for secure authentication and authorization. It utilizes Spring Security for core security functionalities and JJWT for JWT specific operations.

## Technologies Used

* **Spring Boot:** 3.5.3
* **Java Version:** 17
* **Build Tool:** Maven

## Key Dependencies

* **`spring-boot-starter-data-jpa`**: For working with JPA and database interactions.
* **`spring-boot-starter-security`**: Provides core Spring Security features for authentication and authorization.
* **`spring-boot-starter-web`**: Enables building web applications, including RESTful APIs.
* **`mysql-connector-j`**: MySQL JDBC driver for database connectivity (runtime scope).
* **`lombok`**: Simplifies Java development by reducing boilerplate code (e.g., getters, setters, constructors).
* **`jjwt-api`, `jjwt-impl`, `jjwt-jackson`**: JSON Web Token library for generating, parsing, and validating JWTs (version 0.12.3).
* **`spring-boot-starter-test`**: For writing unit and integration tests.
* **`spring-security-test`**: Provides utilities for testing Spring Security enabled applications.

## Getting Started

### Prerequisites

* Java Development Kit (JDK) 17 or higher
* Maven
* MySQL Database (or configure for another database if preferred)

### Setup

1.  **Clone the repository:**
    ```bash
    git clone [https://github.com/your-username/jwt.git](https://github.com/your-username/jwt.git) # Replace with your actual repo URL
    cd jwt
    ```
2.  **Configure Database:**
    * Open `src/main/resources/
