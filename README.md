Markdown
# Task Tracker API (Spring Boot + MySQL)

This is a robust RESTful Backend implementation for the [roadmap.sh Task Tracker](https://roadmap.sh/projects/task-tracker) project. While the original challenge suggests a CLI, this version provides a full API layer with a persistent MySQL database, Service-oriented architecture, and automated auditing.

## 🚀 Features

- **Full CRUD Operations**: Create, Read, Update, and Delete tasks.
- **Status Management**: Transition tasks between `TODO`, `IN_PROGRESS`, and `DONE`.
- **Filtering**: List tasks by their current status using URL parameters.
- **Automated Timestamps**: Tracks `createdAt` and `updatedAt` automatically using JPA lifecycle hooks.
- **Professional Architecture**: Uses the Controller-Service-Repository pattern for clean separation of concerns.

## 🛠 Tech Stack

- **Java 21**
- **Spring Boot 3.x**
- **Spring Data JPA** (Hibernate)
- **MySQL** (Database)
- **Lombok** (Boilerplate reduction)

## 📋 Prerequisites

- **JDK 21** or higher
- **Maven** (included via `./mvnw`)
- **MySQL Server** running locally

## ⚙️ Setup & Installation

1. **Clone the repository**:
   ```bash
   git clone [https://github.com/massaotani/task-manager-api.git](https://github.com/massaotani/task-manager-api.git)
   cd task-manager-api