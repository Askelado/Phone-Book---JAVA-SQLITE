# 📒 Java SQLite Contact Book

A lightweight, command-line contact management application built with **Java** and **SQLite**. The project focuses on clean database integration via JDBC, modular code structure, and structured version control workflows.

---

## ✨ Features

- **Add Contacts:** Save new records with names, phone numbers, and email addresses.
- **View All Contacts:** Display stored contacts in a clean, readable console format.
- **Update & Delete:** Modify existing contact details or remove records safely from the database.
- **Local Persistence:** Data is stored locally in an embedded SQLite database file, automatically initialized on startup.

---

## 🛠️ Tech Stack & Architecture

- **Language:** Java
- **Database:** SQLite (connected via `sqlite-jdbc`)
- **Dependency Management:** Apache Maven (`pom.xml` handles the SQLite JDBC driver)
- **Version Control:** Git & GitHub (using feature branches and atomic commits)

---

## 📂 Project Overview

The codebase is organized cleanly into separate responsibilities:
- **Main Class:** Handles the interactive console menu and user input.
- **Model (`Contact`):** Represents the contact entity and its attributes.
- **Database / DAO:** Manages the SQLite connection, table creation, and CRUD SQL queries.

---

## 🚀 Future Improvements & Contributions

This project is actively open to enhancements and refactoring over time. Planned and potential future updates include:
- **Graphical User Interface (GUI):** Transitioning from the console interface to a desktop UI (e.g., using JavaFX).
- **Extended Features:** Adding contact categories, export/import options (CSV), and input validation enhancements.

Feedback, suggestions, and contributions are always welcome!
