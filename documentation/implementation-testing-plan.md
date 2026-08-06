# Project Documentation

## Project Brief/Description:
As part of the CFG +Masters in Java, Group 2 have created a small Spring Boot API that addresses the following scenario:
- An independent coffee company sells bags of their own ground/bean coffee in a variety of blends, sizes etc.
- They need an app that can connect to their product database and provide the following initial functionality:
  - add new products to the database
  - delete obsolete products from the database
  - update pricing of a certain product
  - update stock count of a certain product
  - adjust stock count of a certain product
  - retrieve information on products matching certain criteria i.e. retrieving only Ground coffee with a strength of 3. 

# Summary of Intent:
The App will use various REST endpoint methods to store, update and retrieve data regarding the products themselves and stock numbers. .
The App will be connected to a MySql Database via the use of JPA Entities.
This API could potentially be adapted for use for various small companies. It's main purposes are:
- storage, retrieval, amendment and updating of data in relation to all products sold int he store.

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

