#!/bin/bash

echo "=========================================================="
echo "Starting the Docker Compose Process for Accountify App..."
echo "=========================================================="

# Build the application using Maven (skip tests)
echo "Building the application with Maven..."
mvn clean install -DskipTests

# Check if Maven build was successful
if [ $? -ne 0 ]; then
    echo "Maven build failed! Exiting..."
    exit 1
fi

# Build the Docker images
echo "Building Docker images..."
docker-compose build

# Check if Docker build was successful
if [ $? -ne 0 ]; then
    echo "Docker build failed! Exiting..."
    exit 1
fi

# Start the containers in detached mode
echo "Starting the containers..."
docker-compose up -d

# Check if Docker containers started successfully
if [ $? -ne 0 ]; then
    echo "Failed to start containers! Exiting..."
    exit 1
fi

# Display running containers
echo "=========================================================="
echo "Docker containers are now running:"
echo "=========================================================="
docker ps

echo "=========================================================="
echo "All tasks completed successfully."
echo "=========================================================="
