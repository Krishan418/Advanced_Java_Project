# Event Management System

A modern and robust Event Management system built with Spring Boot, Thymeleaf, and MySQL.

## 🚀 Key Features

- **Page Controller**: Seamless navigation between core pages.
- **Thymeleaf Integration**: Dynamic server-side rendering with a modern look and feel.
- **Database Persistence**: Integrated with Spring Data JPA and MySQL for reliable data management.
- **API Documentation**: Built-in Swagger UI for exploring and testing endpoints.

## 🛠️ Tech Stack

- **Framework**: Spring Boot 4.0.5
- **Template Engine**: Thymeleaf
- **Language**: Java 21
- **Database**: MySQL
- **Build Tool**: Maven
- **Lombok**: Reduced boilerplate code for cleaner development.
- **SpringDoc OpenAPI**: Interactive API documentation.

## 📦 Getting Started

### Prerequisites

- Java 21 or higher
- Maven (or use the provided `mvnw`)
- MySQL Server

### Database Setup

1. Create a MySQL database named `event_management`.
2. Update the `src/main/resources/application.properties` file with your MySQL credentials:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/event_management
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

### Running the Application

1. Open a terminal in the project root.
2. Run the following command:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Access the application at `http://localhost:8080`.

## 📖 API Documentation

Explore the interactive API documentation at:
`http://localhost:8080/swagger-ui/index.html`

## 🏗️ Project Structure

- `src/main/java`: Backend source code (Controllers, Services, Repositories, Models).
- `src/main/resources/templates`: Thymeleaf templates for the UI.
- `src/main/resources/static`: Static assets (CSS, JS, Images).
