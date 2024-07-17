# Kotlin JavaFX Spring Boot Project

![Hexagonal Architecture Diagram](./Untitled%20Diagram%20%282%29.jpg)

## Overview

This project is a Kotlin-based application that leverages the power of JavaFX for its user interface and Spring Boot for its backend services. The architecture follows the principles of Hexagonal Architecture (also known as Ports and Adapters) to ensure a clean separation of concerns and high testability. The system UI takes inspiration from the modern design principles of C6 Bank, offering a sleek and user-friendly interface.

## C6 Bank Inspiration

C6 Bank is known for its innovative approach to digital banking, providing seamless and intuitive user experience. Their design system is modern, clean, and highly functional, which aligns with the goals of this project to provide a visually appealing and easy-to-use interface. More information about C6 Bank can be found on their [website](https://www.c6bank.com.br/cartao-c6-carbon-mastercard-black).

## Core Technologies

### Kotlin
- **Kotlin**: A modern programming language that makes developers happier. It is concise, safe, interoperable with Java, and provides many ways to reuse code between multiple platforms for productive programming.

### Spring Boot
- **Spring Boot**: A framework that allows the creation of production-ready applications quickly. It provides a wide range of non-functional features that are common to large classes of projects (e.g., embedded servers, security, metrics, health checks, externalized configuration).

### Spring AOP
- **Spring AOP**: Aspect-Oriented Programming framework for modularizing cross-cutting concerns such as logging, transaction management, and security.

### Spring Web
- **Spring Web**: Provides comprehensive support for building web applications. It is part of the Spring Framework and enables the development of RESTful web services and applications.

### Spring Data
- **Spring Data**: Simplifies data access and interaction with databases. It provides a consistent approach to data access, with support for various databases and repositories.

### JavaFX
- **JavaFX**: A software platform for creating and delivering desktop applications, as well as rich Internet applications (RIAs) that can run across a wide variety of devices. JavaFX is intended to replace Swing as the standard GUI library for Java SE.

### H2 Database
- **H2 Database**: A lightweight, embedded, and open-source relational database management system written in Java. It can be used in embedded mode or in server mode.

### OkHttp
- **OkHttp**: An HTTP client that’s efficient by default, speeding up the connections with HTTP/2, connection pooling, and transparent GZIP.

## Functionality

This application provides the following key features:

1. **User Management**: Users can sign up, log in, and manage their profiles. Each user has a balance that they can manage.
2. **Transaction Management**: Users can transfer money to other users. Each transaction updates the sender's and recipient's balances accordingly.
3. **Transaction History**: Users can view a history of all their transactions, showing the details of each transaction.
4. **User Notifications**: Users receive notifications for successful operations like login, sign-up, and transactions.

## Project Structure

The project follows a structured approach to ensure a clear separation of concerns and high maintainability.

### Diagram

The diagram below illustrates the Hexagonal Architecture of the application:

![Hexagonal Architecture Diagram](./Untitled%20Diagram%20%282%29.jpg)

## Getting Started

### Prerequisites

- JDK 11 or higher
- Maven
- An IDE like IntelliJ IDEA

### Building and Running the Project

```bash
git clone https://github.com/FelipeAumannRS/kotlin-spring-boot-javafx.git
cd kotlin-spring-boot-javafx
mvn clean install
mvn spring-boot:run
