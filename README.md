Transactions Service
This is a basic transactions service that manages accounts and transactions for cardholders. It supports the creation of accounts and transactions, and tracks the account balance based on transaction types, using MySQL as the database for persistence.

## Technologies Used
1. Java (Recommended language)
2. Spring Boot (Backend framework)
3. MySQL (Database)
4. Docker & Docker Compose (For containerization)
5. JUnit 5 (For Unit Testing)
6. RESTful API


## Setup and Installation
### Prerequisites
Before you begin, make sure you have the following installed:

* Java 11 or higher
* Docker (Optional but recommended for containerized setup)
* Docker Compose (Optional but recommended for containerized setup)
* Git (To clone the repository)
* Windows or Linux/macOS (Depending on your operating system)

## Step 1: Clone the Repository
git clone https://github.com/khushigupta02/accountify.git
cd accountify

## Step 2: Check the Project Directory
Ensure that the following files exist in your project directory:

- run.bat (for Windows)
- run.sh (for Linux/macOS)
- docker-compose.yml (for Docker configuration)

## Step 3: Running the Application
There are two ways to run the application: using Docker or locally without Docker.

### Option 1: Run Using run.sh or run.bat Scripts
We have provided run.sh and run.bat files for easy execution of the application. The script will automatically check if Docker is installed and decide whether to run the application using Docker or locally with Maven.

### For Linux/macOS:
1. Ensure run.sh has execution permissions:
chmod +x run.sh

2.Run the application using the run.sh script:
./run.sh

### For Windows:
Run the application using the run.bat script:
run.bat

Both scripts perform the following:

#### Check if Docker is installed:
- If Docker is installed, it will start the application and MySQL database using Docker Compose.
- If Docker is not installed, the script will attempt to run the application locally with Maven.

### Option 2: Run Using Docker (Docker & Docker Compose Required)
If you prefer to run the application using Docker, you can use docker-compose to spin up both the Spring Boot application and the MySQL container.

1. Build and start the containers:
docker-compose up --build

2.Access the application: Once the services are up, the application will be available at http://localhost:8080.

3.Stop the services when done: To stop the running services, use:
docker-compose down

### Option 3: Run Locally Without Docker (Maven Required)
If you don't want to use Docker and prefer to run the application locally, follow these steps:
1. Build the project with Maven:
mvn clean install

2. Run the application locally:
./mvnw spring-boot:run

3. Access the application: Once the application is up and running, you can access it at http://localhost:8080.

## API Endpoints

### 1. Create an Account
- POST /accounts/createAccount
- Request body:
{
  "document_number": "12345678900"
}

- Response :
{
  "account_id": 1,
  "document_number": "12345678900"
}

### 2. Retrieve Account Information
- GET /accounts/{accountId}
- Example request: GET /accounts/1
- Response :
{
  "account_id": 1,
  "document_number": "12345678900"

}

### 3. Retrieve All Account Information
- GET /accounts/getAll
- Example request: GET /accounts/getAll
- Response :
[
  {
    "account_id": 1,
    "document_number": "12345678900"
  },
  {
    "account_id": 2,
    "document_number": "12345678800"
  }
]

### 4. Create a Transaction
- POST /transactions/create
- Request body:
{
  "accountId": 1,
  "operationTypeId": 2,
  "amount": -100.00
}
- Response :
  {
  "transaction_id": 1,
  "account_id": 1,
  "operation_type_id": 4,
  "amount": 150.00,
  "timestamp": "2024-11-14T10:00:00"
}
