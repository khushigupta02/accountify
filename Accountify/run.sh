#!/bin/bash

echo "Starting Accountify Application..."

# Build the application using Maven (skip tests)
mvn clean install -DskipTests

# Build the Docker containers using Docker Compose
docker-compose build

# Start the containers in detached mode
docker-compose up -d

# Output the running containers to the console
docker ps

echo "Application started successfully."
