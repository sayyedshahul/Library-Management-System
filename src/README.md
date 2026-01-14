# Library Management System (LMS)

A console-based Java application that allows librarians to manage books, users, and book issuing using clean object-oriented design and modern Java practices.

## Why this project?

This Library Management System demonstrates how real business rules
(book availability, user registration, and issuing constraints) can be
implemented in Java using clean architecture, collections, and modern APIs.

## Features

- Add, remove, and search books
- Register and manage users
- Issue and return books
- Prevent duplicate book issuance
- Search by title or author
- Calculate due dates and fines

## Tech Stack

- Java 17+
- Object-Oriented Programming
- Java Collections
- Java Streams & Lambdas
- Git for version control

## How to Run

1. Clone the repository
2. Open the project in IntelliJ IDEA or any Java IDE
3. Run the `Main` class
4. Follow the console menu to manage books and users

## Project Structure

- `Book` – represents a library book
- `User` – represents a library member
- `App`  - user interaction & menu handling
- `UserManager` – core user management business logic
- `LibraryManager` – core library business logic

## Design Decisions

- Used `ArrayList` for in-memory storage for simplicity
- Used `java.time.LocalDate` for date handling
- Used Streams and lambdas for searching and filtering
- Separated business logic from user interaction

## Future Improvements

- Persist data using a database
- Add user authentication
- Convert to a Spring Boot web application


