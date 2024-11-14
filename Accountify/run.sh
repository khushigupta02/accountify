#!/bin/bash

echo "=========================================================="
echo "Starting the Docker Compose Process for Accountify App..."
echo "=========================================================="

# Build Docker images
echo "Building Docker images..."
docker-compose build
if [ $? -ne 0 ]; then
    echo "Build failed! Exiting..."
    exit 1
fi

# Start containers in detached mode (run in background)
echo "Starting the containers..."
docker-compose up -d
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
