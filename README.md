# Policy Planner: An Insurance Calculator Application
This is a web application built with Spring Boot and Angular that provides an insurance premium calculation service. It allows users to input their vehicle and driving history information to get estimated annual and monthly insurance premiums.

# Prerequisites
Before running the application, make sure you have the following installed on your machine:
- Java Development Kit (JDK) 17 or later
- Node.js and npm (Node Package Manager)
- Docker (if you want to run through Docker)

# Running the Application
There are multiple options for running the application: using Docker or running it locally.

## Option 1: Docker (recommended)
To run the application using Docker, follow these steps:

### 1. Clone the repository to your local machine:
```
git clone https://github.com/hershk17/connex-assessment.git
```

### 2. Navigate to the project's root directory:
```
cd connex-test
```

### 3. Build the Docker image:
```
docker-compose up --build
```

### 5. Access the application by opening a web browser and visiting http://localhost:4200

## Option 2: Run Locally
To run the application locally, you need to start both the backend (Spring Boot) and frontend (Angular) components.

### 1. Clone the repository to your local machine:
```
git clone https://github.com/hershk17/connex-assessment.git
```

### 2. Navigate to the backend directory:
```
cd insurance-rest-service
```

### 3. Build and run the Spring Boot application:
```
./mvnw spring-boot:run
```
This will start the backend server on http://localhost:8080

### 4. Navigate to the frontend directory:
```
cd insurance-web-app
```

### 5. Install the necessary dependencies:
```
npm install
```

### 6. Start the Angular development server:
```
ng serve
```
This will start the frontend application on http://localhost:4200

### 7. Access the application by opening a web browser and visiting http://localhost:4200

