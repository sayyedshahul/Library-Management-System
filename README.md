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
3. Run the `App` class
4. Follow the console menu to manage books and users

## Project Structure

- `App`  - Application startup and dependency wiring
- `Book` – represents a library book
- `User` – represents a library member
- `UserManager` – core user management business logic
- `LibraryManager` – core book management business logic
- `MenuHandler` - Menu handling for main menu
- `UserManagementMenuHandler` - Menu handling for user management

```
src
└── com
    └── shahulsayyed
        └── lms
            ├── App.java
            ├── library
            │   ├── Book.java
            │   ├── LibraryManager.java
            │   └── MenuHandler.java
            └── user
                ├── User.java
                ├── UserManager.java
                └── UserManagementMenuHandler.java
```

## Design Decisions

- Follows an MVC-style layered architecture with Dependency Injection for loose coupling and testability
- Applies the Single Responsibility Principle to keep classes focused and maintainable
- Uses `ArrayList` for in-memory storage to keep the initial implementation simple
- Uses `java.time.LocalDate` for safe and clear date handling
- Uses Java Streams and lambdas for expressive searching and filtering logic
- Separates business logic from user interaction (menu handling) to improve modularity


## Future Improvements

- Persist data using a database
- Add user authentication
- Convert to a Spring Boot web application


