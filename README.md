# 🚑 Ambulance Report System

<p align="center">

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge\&logo=openjdk\&logoColor=white)
![Swing](https://img.shields.io/badge/Java-Swing-red?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge\&logo=mysql\&logoColor=white)
![JDBC](https://img.shields.io/badge/JDBC-Database-success?style=for-the-badge)
![OOP](https://img.shields.io/badge/OOP-Design-blueviolet?style=for-the-badge)
![Git](https://img.shields.io/badge/Git-Version_Control-F05032?style=for-the-badge\&logo=git\&logoColor=white)

</p>

---

# Overview

The **Ambulance Report System** is a desktop-based healthcare management application developed using **Java Swing**, **JDBC**, and **MySQL**. It streamlines ambulance reporting by replacing manual paperwork with a structured digital system for recording patient information, medical history, assessments, and emergency response details.

The project follows **Object-Oriented Programming principles** and adopts the **DAO (Data Access Object) design pattern** to separate business logic from database operations, resulting in a modular and maintainable application.

---

# Key Features

* Secure Login Authentication
* Patient Registration & Management
* Medical History Records
* Patient Assessment Module
* Emergency Response Management
* Complete CRUD Operations
* Search and Retrieve Patient Records
* MySQL Database Integration
* Modular Java Swing Interface
* Clean DAO-Based Architecture

---

# Technology Stack

| Category              | Technologies                      |
| --------------------- | --------------------------------- |
| Programming Language  | Java 17                           |
| GUI Framework         | Java Swing                        |
| Database              | MySQL                             |
| Database Connectivity | JDBC                              |
| Architecture          | DAO Pattern                       |
| Programming Paradigm  | Object-Oriented Programming (OOP) |
| Version Control       | Git & GitHub                      |

---

# Software Architecture

The project is organised using a layered architecture to improve readability, scalability, and maintainability.

```
Ambulance-Report-System
│
├── auth          # Authentication
├── dao           # DAO Interfaces
├── daoimpl       # DAO Implementations
├── db            # Database Connection
├── gui           # Swing User Interface
├── model         # Entity Classes
├── main          # Application Entry Point
│
├── mysql-connector-j-9.6.0.jar
└── README.md
```

---

# System Modules

* Authentication
* Patient Management
* Medical History
* Patient Assessment
* Emergency Response
* Database Management

---

# Project Highlights

This project demonstrates practical experience with:

* Object-Oriented Programming
* Layered Software Architecture
* DAO Design Pattern
* Java Swing GUI Development
* JDBC Connectivity
* Relational Database Design
* SQL CRUD Operations
* Modular Code Organisation
* Exception Handling
* Database Integration

---

# Installation

## Clone Repository

```bash
git clone https://github.com/yashfamustafa/Ambulance-Report-System.git
```

---

## Configure Database

Create a MySQL database.

```sql
CREATE DATABASE ambulance;
```

Import the provided SQL file.

---

## Configure JDBC

Update your database credentials.

```java
String url = "jdbc:mysql://localhost:3306/ambulance";
String username = "root";
String password = "your_password";
```

---

## Add MySQL Connector

Add the MySQL Connector JAR to the project's build path.

---

## Run

Execute the `Main` class to launch the application.

---

# Screenshots

> Screenshots of the Login Screen, Dashboard, Patient Management, Assessment Module, and Emergency Response Module can be added here.

```
screenshots/
    login.png
    dashboard.png
    patient.png
    assessment.png
    response.png
```

---

# Project Presentation

The repository includes a presentation covering:

* Project Objectives
* Problem Statement
* Proposed Solution
* System Architecture
* Database Design
* GUI Design
* Implementation
* Testing
* Future Enhancements

📂 **Presentation**

```
docs/
    Ambulance_Report_System_Presentation.pptx
```

---

# Future Enhancements

* Role-Based Access Control
* PDF Report Generation
* Dashboard Analytics
* Appointment Scheduling
* Cloud Database Support
* Export to Excel/PDF
* Advanced Search & Filtering
* Responsive User Interface

---

# Skills Demonstrated

* Java Development
* Software Engineering
* Database Design
* JDBC Programming
* Java Swing
* SQL
* CRUD Operations
* Object-Oriented Design
* Git & GitHub
* Problem Solving

---

# Author

### Yashfa Mustafa

Software Engineering Student passionate about building desktop and web applications using modern software engineering principles.

**GitHub**

https://github.com/yashfamustafa

---

# Contributing

Contributions, suggestions, and improvements are welcome. Feel free to fork the repository and submit a pull request.

---

# License

This project is provided for educational and learning purposes.

---

⭐ If you found this project helpful, consider giving it a star.
