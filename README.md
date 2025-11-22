# Continuous Deployment Pipeline for Web Application

📄 Arthur's Petitions — Spring Boot Web Application

A simple petition web application built with Spring Boot, Thymeleaf, and Java 17 as part of the CT5171 Continuous Deployment assignment.

🚀 Features

This web application allows users to:

✍️ Create a petition

📄 View all petitions

🔍 Search for a petition

👁️ Click into a petition to view details

✏️ Sign a petition (name + email)

📦 Stores data using in-memory lists (no database required)

🛠️ Technologies Used

Java 17

Spring Boot 3

Maven

Thymeleaf

Jenkins (CI/CD Pipeline)

Docker (for Jenkins + Tomcat)

GitHub Webhooks

Ngrok

📁 Project Structure
src/main/java/ie/nuigalway/ct5171
├── controller/      # Web controllers
├── model/           # Petition + Signature classes
├── service/         # In-memory service layer
└── ArthursPetitionsApplication.java

src/main/resources/templates
├── list-petitions.html
├── create-petition.html
├── search.html
├── search-results.html
└── petition-details.html

▶️ Running the Application

Inside IntelliJ:

Run ArthursPetitionsApplication


Then open:

http://localhost:8080/petitions

🔧 CI/CD Pipeline

This project includes a Jenkinsfile that supports:

Pull source code from GitHub

Build with Maven

Run tests

Package as a WAR:

arthurspetitions.war


Manual approval step

Deployment to a Tomcat container (via Docker)