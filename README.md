# Car Comparison API

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.9-green)
![Google Cloud Run](https://img.shields.io/badge/Google_Cloud-Run-blue)
![PostgreSQL](https://img.shields.io/badge/Database-Neon_Postgres-purple)
![Docker](https://img.shields.io/badge/Container-Docker-blue)

A robust RESTful API for managing and comparing vehicle data, deployed as a serverless container on Google Cloud Platform.

### [**View Live API Documentation (Swagger UI)**](https://car-comparison-backend-477893767706.us-east1.run.app)
*(Note: Please allow some time for the website to load)*

---

## About The Project
This project demonstrates a cloud-native backend architecture. Instead of a traditional monolithic deployment, this API is containerized using Docker and orchestrated via Google Cloud Run, ensuring it scales to zero when not in use to optimize costs.

**Key Features:**
* **RESTful Architecture:** Comprehensive CRUD operations for vehicle data.
* **AI Integration:** Recieve a value score with an analysis powered by Google Gemini for any given vehicle.
* **Business Logic:** Advanced filtering, direct comparison of two cars, depreciation calculation over 5 years.
* **Cloud Native:** Fully stateless architecture suitable for serverless deployment.
* **External Database:** Connects securely to a managed PostgreSQL instance (Neon.tech).
* **Automated Documentation:** Integrated OpenAPI (Swagger) specification.
* **Testing:** Unit and Integration testing with JUnit and Mockito.

## Tech Stack
* **Framework:** Java 21, Spring Boot 3.5.9
* **Database:** PostgreSQL (Hosted on Neon.tech)
* **Containerization:** Docker & Google Artifact Registry
* **Deployment:** Google Cloud Run (Serverless)
* **Build Tool:** Maven
* **Testing:** JUnit 5 & Mockito

## Cloud Architecture & Deployment

1.  **Containerization:** The application is packaged into a Docker image.
2.  **Registry:** Images are pushed to **Google Artifact Registry**.
3.  **Execution:** **Google Cloud Run** pulls the image and creates a stateless HTTP container.
4.  **Persistence:** The app connects to a remote **Neon PostgreSQL** database via environment variables.

## API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| `GET` | /api/cars/{id} | Search for a car by ID | 
| `PUT` | /api/cars/{id} | Edit an existing car in the database | 
| `DELETE` | /api/cars/{id} | Remove a car from the databse by ID | 
| `GET` | /api/cars | Search for cars that match certain parameters | 
| `POST` | /api/cars | Add a new car to the database | 
| `GET`| /api/cars/{id}/valuescore | Generate a value score wth AI analysis for a car by ID | 
| `GET`| /api/cars/{id}/depreciation | Calculate the depreciation for a car over 5 years by ID | 
| `GET`| /api/cars/compare | Compare differences between two cars by ID | 
| `GET`| /api/cars/all | Return all cars in the database | 

## How to Run Locally

**Prerequisites:**
* Java 17+ (https://www.oracle.com/java/technologies/downloads/)
* Maven (https://maven.apache.org/download.cgi)
* Git (https://git-scm.com/install/)

**1. Clone the repo from your terminal or command prompt**
```
git clone https://github.com/zachprogramming1684/Mock-Banking-App.git
```

**2. Navigate to the cloned repository**
```
cd car-comparison-website/backend
```

**3. Build and run the project**  

*Windows:*  
```
mvnw spring-boot:run
```
*MacOS/Linux:*
```
mvn spring-boot:run
```
You can access the API endpoints at `localhost:8080` in your browser.    
Simply press `Ctrl + C` in your terminal to terminate the program.
