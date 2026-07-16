# 🚑 Ambulance Report System

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge&logo=mysql)
![JDBC](https://img.shields.io/badge/JDBC-Connectivity-success?style=for-the-badge)
![Swing](https://img.shields.io/badge/Java-Swing-red?style=for-the-badge)
![GitHub](https://img.shields.io/badge/GitHub-Repository-black?style=for-the-badge&logo=github)
![License](https://img.shields.io/badge/License-Educational-green?style=for-the-badge)

A desktop-based **Ambulance Report System** developed using **Java Swing**, **JDBC**, and **MySQL** to manage ambulance operations, patient records, medical history, assessments, and emergency response details through an intuitive graphical user interface.

---

## 📌 Project Overview

The Ambulance Report System is designed to digitize ambulance reporting and patient management. Instead of maintaining paper records, users can securely store and manage emergency case information in a MySQL database through an easy-to-use desktop application.

This project demonstrates practical implementation of:

- Object-Oriented Programming (OOP)
- Java Swing GUI Development
- JDBC Database Connectivity
- MySQL Database Management
- CRUD Operations
- DAO Design Pattern

---

## ✨ Features

- 🔐 Login Authentication
- 👤 Patient Registration
- 🩺 Patient Assessment
- 📋 Medical History Management
- 🚑 Emergency Response Records
- 💾 MySQL Database Integration
- 🔍 Search Records
- ➕ Add Records
- ✏️ Update Records
- ❌ Delete Records
- 🖥 User-Friendly Interface

---

## 🛠 Technologies Used

| Technology | Description |
|------------|-------------|
| Java | Core Programming Language |
| Java Swing | GUI Development |
| JDBC | Database Connectivity |
| MySQL | Database Management |
| OOP | Software Design |
| Git & GitHub | Version Control |

---

## 📂 Project Structure

```
Ambulance-Report-System
│
├── auth
├── dao
├── daoimpl
├── db
├── gui
├── main
├── model
│
├── mysql-connector-j-9.6.0.jar
│
├── screenshots
│
└── README.md
```

---

## 📸 Screenshots

### 🔐 Login Screen

> Add your screenshot here

```
screenshots/login.png
```

---

### 🏠 Dashboard

> Add your screenshot here

```
screenshots/dashboard.png
```

---

### 👤 Patient Module

> Add your screenshot here

```
screenshots/patient.png
```

---

### 🩺 Assessment Module

> Add your screenshot here

```
screenshots/assessment.png
```

---

### 🚑 Emergency Response Module

> Add your screenshot here

```
screenshots/response.png
```

---

## ⚙️ Installation

### Clone the Repository

```bash
git clone https://github.com/yourusername/Ambulance-Report-System.git
```

### Open the Project

Open the project using:

- IntelliJ IDEA
- Eclipse
- NetBeans

---

### Import Database

Create a MySQL database:

```sql
CREATE DATABASE ambulance;
```

Import the provided SQL file into the database.

---

### Configure Database Connection

Update your database credentials inside your DB connection class.

Example:

```java
String url = "jdbc:mysql://localhost:3306/ambulance";
String username = "root";
String password = "your_password";
```

---

### Add JDBC Driver

Include the MySQL Connector JAR file in your project libraries.

---

### Run the Application

Run the main Java class to launch the application.

---

## 🗃 Database Modules

- Patient Information
- Medical History
- Assessment
- Emergency Response

---

## 🎯 Learning Outcomes

This project helped me improve my skills in:

- Java Programming
- Java Swing
- JDBC
- MySQL
- CRUD Operations
- DAO Pattern
- GUI Design
- Git & GitHub
- Software Engineering Principles

---

## 🚀 Future Improvements

- PDF Report Generation
- User Roles (Admin/Staff)
- Advanced Search Filters
- Data Validation
- Dashboard Analytics
- Appointment Scheduling
- Cloud Database Support
- Responsive Modern UI

---

## 🤝 Contributing

Contributions, suggestions, and improvements are welcome.

Feel free to fork this repository and submit a pull request.

---

## 👩‍💻 Author

### **Yashfa Mustafa**

Software Engineering Student

- 💻 Java Developer
- 🌐 Learning Full-Stack Web Development
- 🗄 MySQL & Database Design Enthusiast

GitHub:
https://github.com/yashfamustafa

---

## ⭐ Support

If you found this project useful, consider giving it a ⭐ on GitHub.

---

## 📄 License

This project is developed for educational and learning purposes.
