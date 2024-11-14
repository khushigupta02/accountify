@echo off
echo ==========================================================
echo Starting the Docker Compose Process for Accountify App...
echo ==========================================================

:: Build Docker images
echo Building Docker images...
docker-compose build

:: Check if the build was successful
IF %ERRORLEVEL% NEQ 0 (
    echo Build failed! Exiting...
    pause
    exit /b %ERRORLEVEL%
)

:: Start containers in detached mode (run in background)
echo Starting the containers...
docker-compose up -d

:: Check if the containers started successfully
IF %ERRORLEVEL% NEQ 0 (
    echo Failed to start containers! Exiting...
    pause
    exit /b %ERRORLEVEL%
)

:: Display running containers
echo ==========================================================
echo Docker containers are now running:
echo ==========================================================
docker ps

echo ==========================================================
echo All tasks completed successfully.
echo ==========================================================
pause
