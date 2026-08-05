# Project Documentation

## Project Description:
A Spring Boot REST API created with the intention of being used by an independent coffee product company.
The company sells coffee bags of various blends, sizes, types (ground vs bean). 
The App will use various REST endpoint methods to store, update and retrieve data regarding the products themselves and stock numbers. .
The App will be connected to a MySql Database via the use of JPA Entities. 

## MVP vs. NTH:
MVP:
- 2 rest endpoints
- Robust Unit Testing for each endpoint
- Adequate use of 
## Potential Methods/Functionality (REST ENDPOINTS) - discussed during meeting:
### GET:
- getDecafProducts (Jade)

### POST:
- addNewProduct - Andrina
-
### UPDATE:
- updateStock - (Ameenah) adds one to totalOrders/ takes one from stockTotal (potentially low stock warning) 
-
### DELETE:
- deleteProduct - Caroline
-
## Implementation Plan
**1. SETUP**
  - [x] Use Spring initializr to create a Spring Boot API with application.yaml and known dependencies.
  - [x] Create GitHub repository and add all group members as collaborators.
  - [x] Populate the API with template/base requirement files, including:
    - [x] documentation folder for MD file detailing implementation, testing and project requirements.
    - [x] create initial folder structure:
    ```
    group2project/
    ├── .idea/
    ├── .mvn/
    ├── documentation/
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   │   └── com/cfgmasters/CoffeeApp/
    │   │   │       ├── controller/
    │   │   │       │   └── CoffeeProductController.java
    │   │   │       ├── model.entity/
    │   │   │       │   ├── CoffeeProduct.java
    │   │   │       │   └── CoffeeType.java
    │   │   │       ├── repository/
    │   │   │       │   └── CoffeeProductRepository.java
    │   │   │       ├── services/
    │   │   │       │   └── CoffeeProductService.java
    │   │   │       └── CoffeeApp.java
    │   │   └── resources/
    │   │       ├── application.yaml
    │   │       └── coffeeDB.sql
    │   └── test/
    └── target/
    ├── classes/
    └── generated-sources/

**2. DATABASE CONNECTION & CONFIG**
- [x] Database setup: Use MySQL IDE to create:
  - [x] coffee database
  - [x] products table
  - [x] insert seed data for testing
- [x] Configuration: Update application.yaml with database URL, username and password.
- [x] Use environment variables or template version to put to GitHub to ensure personal passwords are not pushed: **ADD original application.yaml to .gitignore if using second method!**)

**2.REST ENDPOINTS**
- [x] Discuss MVP endpoints in Zoom call.
  - [x] Assign each group member a REST endpoint and assign date for this to be completed.
    - GET: getDecafProducts - Jade
    - POST: addNewProduct - Andrina
    - PUT: updateStock - (Ameenah) adds one to totalOrders/ takes one from stockTotal (potentially low stock warning)
    - Caroline - TBC
    - Kerene - TBC
    - Date to Complete: Tuesday 4th August

- [] Each group member will test their individual REST ENDPOINT method:
- using Mockito to create mock data
- 
- should have relevant exceptions and Unit Testing. 
Other Responsibilities:
- [] Update implementation doc (Jade)
- [] Andrina presentation
- [] Ameenah Dockerfile

# Test Plan:
# Manual Test Plan:
TEST 1: Does the app connect to the MySQL Database?
Manual test: Use a test GET endpoint i.e. /hello in browser to call "Hello from Coffee API".

TEST 2: Using POSTMAN, we manually tested each other's end points to make sure they work as we would expect:
Endpoint: 
Test: http://localhost:8080/products/adjustStock/1?amount=5


#