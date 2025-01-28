# Employee System

This application allows you to keep track of employees, where each employee has their own characteristics.

## Technologies Used

- Java 17
- Spring Boot 3.4.2
- Maven
- PostgreSQL (via Docker)

## Project Description

Employee System is a Java-based application built with Spring Boot. It allows you to save employees in a database with their specific characteristics, as well as delete employees and change their characteristics as needed.

## Setup Instructions

### Prerequisites

- Java 17
- Maven
- Docker

### Running the Project

1. Clone the repository:

   git clone https://github.com/20Greyes02/Employee-System.git
   cd Employee-System
  

2. Build the project using Maven:
   
   mvn clean install
  

3. Run the Docker container for PostgreSQL:
   
   docker-compose up -d
  

4. Run the Spring Boot application:
   
   mvn spring-boot:run
  

### Database Configuration

The project uses PostgreSQL as the database. To change the database configuration:

1. Open the `application.properties` file located in `src/main/resources`.
2. Update the database connection properties to match your new database configuration:
   properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
   spring.datasource.username=your_username
   spring.datasource.password=your_password


3. Update the `pom.xml` file to include the dependency for your new database if necessary:
   xml
   <dependency>
       <groupId>com.your.database</groupId>
       <artifactId>your-database-driver</artifactId>
       <scope>runtime</scope>
   </dependency>


## Acknowledgments

- Spring Boot
- PostgreSQL
- Docker
