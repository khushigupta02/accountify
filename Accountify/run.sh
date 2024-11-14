#!/bin/bash

echo "=========================================================="
echo "Starting the Docker Compose Process for Accountify App..."
echo "=========================================================="

# Build Docker images
echo "Building Docker images..."
docker-compose build

# Check if the build was successful
if [ $? -ne 0 ]; then
    echo "Build failed! Exiting..."
    exit 1
fi

# Start containers in detached mode (run in background)
echo "Starting the containers..."
docker-compose up -d

# Check if the containers started successfully
if [ $? -ne 0 ]; then
    echo "Failed to start containers! Exiting..."
    exit 1
fi

# Wait for containers to be up and running
echo "Waiting for containers to be fully up and running..."
MAX_RETRIES=10
RETRY_COUNT=0
CONTAINER_UP=false

while [ $RETRY_COUNT -lt $MAX_RETRIES ]; do
    # Check if the container is up
    if docker ps | grep -q "accountify"; then
        CONTAINER_UP=true
        break
    fi

    echo "Containers not up yet... Retrying ($((RETRY_COUNT+1))/$MAX_RETRIES)"
    RETRY_COUNT=$((RETRY_COUNT+1))
    sleep 5
done

if [ "$CONTAINER_UP" = false ]; then
    echo "Containers failed to start after $MAX_RETRIES attempts! Exiting..."
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
