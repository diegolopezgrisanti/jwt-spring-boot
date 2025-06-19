# 🛡️ JWT Spring Security App

A backend application built with **Spring Boot**, **Spring Security**, and **JWT**, handling user authentication, token-based authorization, token refresh, and secure access to protected endpoints. It uses **PostgreSQL** as the database via Docker.

---

## 🚀 Features

- Authentication using **JWT** and refresh tokens
- User registration and login
- Secure logout with token revocation
- Public and protected API routes
- Stateless security using Spring Security filters
- PostgreSQL integration with Docker
- Clean architecture: controller, service, repository
- Configuration via `application.yml`

---

## ⚙️ Technologies

- Java 21
- Spring Boot
- Spring Security
- JSON Web Token (JWT)
- PostgreSQL (via Docker)
- Maven
- Lombok
- JPA / Hibernate

---

## 🐳 PostgreSQL Setup with Docker

Run the following command to start a PostgreSQL container locally:

```bash
docker-compose up -d
```
The included docker-compose.yml file sets up PostgreSQL and exposes it on port 5432.

---

## 📁 Configuration (`application.yml`)

```yaml
server:
  port: 8080

application:
  security:
    jwt:
      secret-key: ${JWT_SECRET_KEY}
      expiration: 86400000 # 1 day
      refresh-token:
        expiration: 604800000 # 7 days

spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/securityDB
    username: admin
    password: admin
  jpa:
    hibernate:
      ddl-auto: create-drop
    show-sql: false
```
> 🔐 **Make sure to set the `JWT_SECRET_KEY` in your environment variables or in a `.env` file.**

---

## 📦 API Endpoints

### 🧾 Authentication

| Method | Endpoint         | Description                     |
|--------|------------------|---------------------------------|
| POST   | `/auth/register` | Register a new user             |
| POST   | `/auth/login`    | Authenticate and return tokens  |
| POST   | `/auth/refresh`  | Refresh access token            |
| POST   | `/auth/logout`   | Revoke access token             |

### 👥 User Management

| Method | Endpoint  | Description           | Authentication |
|--------|-----------|-----------------------|----------------|
| GET    | `/users`  | Get list of all users | ✅ Required     |

---

## 🔑 Authentication Flow Example

### 1. Register

```http
POST /auth/register
Content-Type: application/json

{
  "name": "Diego",
  "email": "diego@gmail.com",
  "password": "123456"
}
```

### 2. Login

```http
POST /auth/login
Content-Type: application/json

{
  "email": "diego@gmail.com",
  "password": "123456"
}
```
**Response:**

```json
{
  "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "refresh_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

### 3. Access a Protected Endpoint

```http
GET /users
Authorization: Bearer {access_token}
```

### 4. Refresh Token

```http
POST /auth/refresh
Authorization: Bearer {refresh_token}
```

### 5. Logout

```http
POST /auth/logout
Authorization: Bearer {access_token}
```

## 🧠 Project Structure
```
src/
├── auth/
│ ├── controller/
│ ├── repository/
│ └── service/
├── config/
└── user/
```

---

## ✅ Security Highlights

- Stateless JWT authentication
- Access & Refresh tokens
- Token expiration and validation
- Token revocation on logout
- Custom JWT filter (`JwtAuthFilter`)
- Password encryption with BCrypt

---

## 👤 Author

**Diego López Grisanti**  
🔗 [GitHub Profile](https://github.com/diegolopezgrisanti)

