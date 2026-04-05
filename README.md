Markdown
# Task Tracker API (Spring Boot)

This is a robust RESTful Backend implementation for the [roadmap.sh Task Tracker](https://roadmap.sh/projects/task-tracker) project. This version provides a full API layer with a H2 database, Service-oriented architecture, and automated auditing.

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

2.  Testing:
   • Create a New Task (POST): This creates the first task. Notice that it defaults to TODO based on the Entity logic.
   ```bash
   curl -i -X POST http://localhost:8080/api/tasks \
   -H "Content-Type: application/json" \
   -d '{"description": "Buy groceries"}'
   ```

   • List All Tasks (GET): To verify all the tasks created/updated so far.
   ```bash
   curl -X GET http://localhost:8080/api/tasks
   ```

   • Update Task Description (PUT): Change the text of the task. Replace 1 with the desired Task ID.
   ```bash
   curl -i -X PUT http://localhost:8080/api/tasks/1 \
   -H "Content-Type: application/json" \
   -d '{"description": "Finish roadmap.sh and push to GitHub"}'
   ```

   • Update Task Status (PATCH): Moving the task to IN_PROGRESS.
   ```bash
   curl -i -X PATCH "http://localhost:8080/api/tasks/1?status=IN_PROGRESS"
   ```

   • Filter Tasks by Status (GET with Params): Test repository’s filtering logic. Returns tasks that are IN_PROGRESS, based on the given Param.
   ```bash
   curl -i -X GET "http://localhost:8080/api/tasks?status=IN_PROGRESS"
   ```

   • Mark as Done (PATCH): Mark the task as finalized.
   ```bash
   curl -i -X PATCH "http://localhost:8080/api/tasks/1?status=DONE"
   ```

   • Delete a Task (DELETE): The final cleanup. This should return a 204 No Content (empty response) if only one Task was added.
   ```bash
   curl -i -v -X DELETE http://localhost:8080/api/tasks/1
   ```
