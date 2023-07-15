# Policy Planner: An Insurance Calculator Application
This is a web application built with Spring Boot and Angular that provides an insurance premium calculation service. It allows users to input their vehicle and driving history information to get estimated annual and monthly insurance premiums.

# About This Project


# Folder Structure
```
.connex-test    // root directory
|
├── insurance-rest-service
│   ├── src
│   │   └── main
│   │       └── java/com/example/insurancerestservice
│   │           ├── controller     // rest controllers to handle api endpoints
│   │           ├── entity         // entities used for data handling
│   │           ├── repository     // Jpa repositories for entities
│   │           ├── service        // service layer for business logic
│   │           └── Application.java
│   ├── DockerFile
│   └── pom.xml
│
├── insurance-web-app
│   ├── src
│   │   ├── app
│   │   │   ├── components      // contains core components of the application
│   │   │   ├── models          // models/interfaces used for handling data
│   │   │   └── services        // services for making http requests
│   │   ├── assets
│   │   │   └── index.html
│   │   ├── app-routing.module.ts    // module which defines routes used
│   │   └── app.module.ts            // imports components and modules
│   ├── .gitignore
│   ├── Dockerfile       
│   └── package.json
│
├── docker-compose.yml   // docker compose file for containerizing applications
└── README.md            // contains project information and usage instructions
```

# Running the Application
There are multiple options for running the application: using Docker or running it locally.

## Prerequisites
Before running the application, make sure you have the following installed on your machine:
- [Java Development Kit (JDK) 17 or later](https://www.oracle.com/ca-en/java/technologies/downloads/#java17)
- [Node.js and npm (Node Package Manager)](https://nodejs.org/en)
- [Docker (to easily run the application)](https://www.docker.com/products/docker-desktop/)

## Option 1: Docker (recommended)
To run the application using Docker, follow these steps:

#### 1. Clone the repository to your local machine:
```
git clone https://github.com/hershk17/connex-assessment.git
```

#### 2. Navigate to the project's root directory:
```
cd connex-test
```

#### 3. Build the Docker image:
```
docker-compose up --build
```

#### 5. Access the application by opening a web browser and visiting http://localhost:4200

## Option 2: Run Locally
To run the application locally, you need to start both the backend (Spring Boot) and frontend (Angular) components.

#### 1. Clone the repository to your local machine:
```
git clone https://github.com/hershk17/connex-assessment.git
```

#### 2. Navigate to the backend directory:
```
cd insurance-rest-service
```

#### 3. Build and run the Spring Boot application:
```
./mvnw spring-boot:run
```
This will start the backend server on http://localhost:8080

#### 4. Navigate to the frontend directory:
```
cd insurance-web-app
```

#### 5. Install the necessary dependencies:
```
npm install
```

#### 6. Start the Angular development server:
```
ng serve
```
This will start the frontend application on http://localhost:4200

#### 7. Access the application by opening a web browser and visiting http://localhost:4200

# Miscellaneous
If you encounter any issues running this application, please reach out to me via email at hersh.k17@gmail.com.

### Thank you!