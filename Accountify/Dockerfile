# Use an official Maven image to build the app
FROM maven:3.8.5-openjdk-17-slim AS build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml and the source code
COPY pom.xml .
COPY src ./src

# Build the project (skip tests)
RUN mvn clean install -DskipTests

# Use an OpenJDK image to run the application
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage (adjust the JAR name as needed)
COPY --from=build /app/target/Accountify-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app will run on (adjust based on your configuration)
EXPOSE 8080

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
