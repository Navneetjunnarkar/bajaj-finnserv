# BFHL API - Bajaj Finserv Health Challenge

A production-ready REST API built with Spring Boot 3 and Java 17 for processing mixed data arrays.

## 📁 Project Structure

```
bfhl-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── navneet/
│   │   │           └── bfhl/
│   │   │               ├── BfhlApiApplication.java
│   │   │               ├── controller/
│   │   │               │   └── BFHLController.java
│   │   │               ├── dto/
│   │   │               │   ├── RequestDTO.java
│   │   │               │   └── ResponseDTO.java
│   │   │               ├── service/
│   │   │               │   ├── BFHLService.java
│   │   │               │   └── impl/
│   │   │               │       └── BFHLServiceImpl.java
│   │   │               └── exception/
│   │   │                   └── GlobalExceptionHandler.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
├── pom.xml
└── README.md
```

## 🚀 Quick Start

### Prerequisites
- Java 17 or higher
- Maven 3.6+

### 1. Clone and Build
```bash
git clone <your-repo-url>
cd bfhl-api
mvn clean install
```

### 2. Run the Application
```bash
mvn spring-boot:run
```

The API will be available at: `http://localhost:8080/api/bfhl`

## 📋 API Documentation

### POST /api/bfhl

**Request:**
```json
{
  "data": ["a", "1", "334", "4", "R", "$"]
}
```

**Response:**
```json
{
  "is_success": true,
  "user_id": "navneet_junnarkar",
  "email": "navneetjunnarkar230210@acropolis.in",
  "roll_number": "0827CY231047",
  "odd_numbers": ["1"],
  "even_numbers": ["334", "4"],
  "alphabets": ["A", "R"],
  "special_characters": ["$"],
  "sum": "339",
  "concat_string": "Ra"
}
```

### GET /api/bfhl

Returns operation code for frontend integration.

## 🧪 Testing

### Using cURL
```bash
curl -X POST http://localhost:8080/api/bfhl \
  -H "Content-Type: application/json" \
  -d '{"data":["a","1","334","4","R","$"]}'
```

### Using Postman
1. Method: POST
2. URL: `http://localhost:8080/api/bfhl`
3. Headers: `Content-Type: application/json`
4. Body (raw JSON):
```json
{
  "data": ["a", "1", "334", "4", "R", "$"]
}
```

## 🔧 Maven Commands

```bash
# Clean and compile
mvn clean compile

# Run tests
mvn test

# Package JAR
mvn clean package

# Run application
mvn spring-boot:run

# Skip tests during build
mvn clean package -DskipTests
```

## 📦 GitHub Deployment

### Initial Setup
```bash
git init
git add .
git commit -m "Initial commit: BFHL API implementation"
git branch -M main
git remote add origin https://github.com/your-username/bfhl-api.git
git push -u origin main
```

### Subsequent Updates
```bash
git add .
git commit -m "Your commit message"
git push
```

## 🌐 Render Deployment

### 1. Connect Repository
- Go to [Render Dashboard](https://dashboard.render.com)
- Click "New +" → "Web Service"
- Connect your GitHub repository

### 2. Configuration
- **Name:** `bfhl-api`
- **Environment:** `Java`
- **Build Command:** `mvn clean package -DskipTests`
- **Start Command:** `java -jar target/bfhl-api-1.0.0.jar`
- **Instance Type:** Free tier

### 3. Environment Variables
```
JAVA_TOOL_OPTIONS=-Xmx512m
SERVER_PORT=10000
```

### 4. Deploy
Click "Create Web Service" and wait for deployment.

Your API will be available at: `https://your-app-name.onrender.com/api/bfhl`

## 🏗️ Business Logic

1. **Number Processing:** Separates odd and even numbers, calculates sum
2. **Alphabet Processing:** Extracts letters, converts to uppercase
3. **Special Characters:** Identifies non-alphanumeric characters
4. **Concat String Logic:**
   - Collects all alphabets
   - Reverses the string
   - Applies alternating case (first uppercase, second lowercase, etc.)

## 🛠️ Technology Stack

- **Java 17**
- **Spring Boot 3.2.0**
- **Maven**
- **Lombok**
- **Spring Web**
- **Spring Validation**

## 👨‍💻 Author

**Navneet Junnarkar**
- Email: navneetjunnarkar230210@acropolis.in
- Roll Number: 0827CY231047

## 📄 License

This project is created for the Bajaj Finserv Health Challenge coding assignment.