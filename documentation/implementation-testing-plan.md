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
- [x] Configuration: **UPDATE THIS**
- [x] Use environment variables or template version to put to GitHub to ensure personal passwords are not pushed: **ADD original application.yaml to .gitignore if using second method!**)

**2.REST ENDPOINTS**
- [x] Discuss MVP endpoints in Zoom call.
- [x] Assign each group member at least **REST endpoint** and assign date for this to be completed.
## Methods/Functionality (REST ENDPOINTS) - discussed during meeting:
### GET:
- `findByBlendTypeAndStrength()`: Search and return products matching blend type AND strength (both values much match).
### POST:
- `addNewProduct()`: Add a new coffee product.
### PUT:
- `updateStock()`: Update coffee stock to a specific amount.
- `adjustStock()`: Adjusts coffee stock by an amount, can be negative or positive.
### PATCH:
  - `updatePrice():` Update only the price of a coffee product.
### DELETE:
- `deleteProduct()`: Delete a coffee product by ID

- [] Each group member will test their individual REST ENDPOINT method:
- using Mockito to create mock data
- 
- should have relevant exceptions and Unit Testing. 
Other Responsibilities:
- [] Update implementation doc (Jade)
- [] Andrina presentation
- [] Ameenah Dockerfile

# ✅👤Manual Testing Phase

Below we have provided information of the manual testing plan implemented throughout the various stages of development of our
group project:

## PHASE 1: Does the application start up successfully?

We incorporated the following output messages to clearly indicate if the SpringBoot app
successfully starts:
```
ConfigurableApplicationContext context = SpringApplication.run(CoffeeApp.class, args);
String serverPort = context.getEnvironment().getProperty("server.port", "8080");
System.out.println("Welcome to the Beans and Grounds Coffee store!");
System.out.println("You can see our API docs at http://localhost:" + serverPort + "/swagger-ui.html");
```
## PHASE 2: Does the app connect to the MySQL Database?

Manual test: Use a test GET endpoint i.e. /hello in browser to call "Hello from Coffee API".

## PHASE 3: Manually test endpoints using POSTMAN:

Once we had each completed the coding for the endpoint, we each picked an endpoint by another
group member and manually tested valid, invalid and boundary inputs. We recorded anything
that did/didn't work to be used by each developer to apply robust error handling and as e.g to later use in unit testing.
Using POSTMAN, we manually tested each other's endpoints to make sure they work as we would expect:

### Test Endpoint: adjustStock()
- *URL Tested:* `http://localhost:8080/products/adjustStock/1?amount=5`
- *Purpose:* Increase stock level of product with ID 1 by a specified amount.
- *Expected Result:* Stock increases from 50 → 55.
- *Actual Result:* Stock correctly adjusted to 55.

### Test Endpoint: updateStock()
- *URL Tested:* `http://localhost:8080/products/updateStock/1?quantity=50`
- *Purpose:* Set the stock level of product with ID 1 to a specific quantity.
- *Expected Result:* Stock resets to 50.
- *Actual Result:* Stock correctly updated to 50.