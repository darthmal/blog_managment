# Blog Management System

A Spring Boot application that provides RESTful APIs for managing blog articles and comments.

## Features

### Blog Management
- Complete CRUD operations for articles
- Comment management system
- Validation for article and comment data integrity

### Blog Management Endpoints
1. Article Endpoints
   - `GET /api/articles` - List all articles
   - `GET /api/articles/{id}` - Get article by ID
   - `POST /api/articles` - Create a new article
   - `PUT /api/articles/{id}` - Update an existing article
   - `DELETE /api/articles/{id}` - Delete an article

2. Comment Endpoints
   - `POST /api/articles/{articleId}/comments` - Add a comment to an article
   - `DELETE /api/articles/{articleId}/comments/{commentId}` - Delete a comment

### Data Validation
- Mandatory fields validation for article title and content
- Mandatory field validation for comment content
- Automatic timestamp management for creation and updates

## Technical Stack

- Java (Spring Boot)
- Spring Data JPA for database operations
- Jakarta Validation for request validation
- Lombok for reducing boilerplate code
- PostgreSQL Database
- Swagger/OpenAPI for API documentation

## Prerequisites

1. Java 17 or higher
2. PostgreSQL 12 or higher
3. IntelliJ IDEA (recommended)
4. Maven 3.6 or higher

## Setup Instructions

### 1. Database Setup

1. Install PostgreSQL if not already installed
2. Create a new database for the application
3. Configure the `.env` file in the project root:
   ```properties
   PORT=8080
   DB_URL=jdbc:postgresql://localhost:5432/your_database_name
   DB_USERNAME=your_username
   DB_PASSWORD=your_password
   ```

### 2. Project Setup in IntelliJ IDEA

1. Clone the repository
2. Open IntelliJ IDEA
3. Go to File -> Open and select the project directory
4. Wait for Maven to download dependencies
5. Copy .env.example to .env and update the values
6. Enable annotation processing for Lombok:
   - Go to Settings -> Build, Execution, Deployment -> Compiler -> Annotation Processors
   - Check Enable annotation processing
7. Make sure PostgreSQL is running (Docker container recommended)
8. Run the application:
   - Find the main application class (likely ending with `Application.java`)
   - Right-click and select Run
   - Or use Maven: `mvn spring-boot:run`
9. The application will start on http://localhost:8080 (or the port specified in your .env file)
10. Access Swagger UI: http://localhost:8080/swagger-ui.html

## API Testing with Swagger UI

Access Swagger UI at http://localhost:8080/swagger-ui.html
- Test all blog endpoints
- View schema documentation for request and response models

## Database Schema

### The articles table includes:
- id (Primary Key)
- title (String, mandatory)
- content (Text, mandatory)
- publication_date (ZonedDateTime)
- created_at (from BaseEntity)
- updated_at (from BaseEntity)

### The comments table includes:
- id (Primary Key)
- content (Text, mandatory)
- article_id (Foreign Key to articles)
- created_at (from BaseEntity)
- updated_at (from BaseEntity)

## Error Handling

### The application provides detailed error messages for:
- Invalid article or comment data
- Article or comment not found
- Validation errors

## Additional Notes

- The API is documented using Swagger/OpenAPI annotations
- Mappers are used to convert between DTOs and entity objects
- Timestamps are automatically managed for all entities