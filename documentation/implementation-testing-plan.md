# Project Implementation

## ☕ Project Brief/Description:
As part of the CFG +Masters in Java, Group 2 have created a small Spring Boot API that addresses the following scenario:
- An independent coffee company sells bags of their own ground/bean coffee in a variety of blends, sizes etc.
- They need an app that can connect to their product database and provide the following initial functionality:
  1. **Add** new products to the database
  2. Delete obsolete products from the database
  3. Update pricing of a certain product
  4. Update stock count of a certain product
  5. Adjust stock count of a certain product
  6. Retrieve information on products matching certain criteria i.e. retrieving only Ground coffee with a strength of 3.
- The App will use various REST endpoint methods to store, update and retrieve data regarding the products themselves and stock numbers. .
- The App will connect to a MySql Database via the use of JPA Entities.
- This API could potentially be adapted for use for various small companies. It's main purposes are: storage, retrieval, amendment and updating of data in relation to all products sold int he store.

## Implementation Plan
**PHASE 1. SETUP**
  - [x] Use Spring initializr to create a Spring Boot API with application.yaml and known dependencies.
  - [x] Create GitHub repository and add all group members as collaborators.
  - [x] Populate the API with template/base requirement files, including:
    - [x] documentation folder for MD file detailing implementation, testing and project requirements.
    - [x] create overall folder structure:
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
- [x] Test connection and configuration settings are working and app runs as expected (see manual testing).

**2.REST ENDPOINTS**
Once set up, configuration and database connection are confirmed, the following will be implemented:
- [x] Group discussion in which each member proposes one **REST endpoint** method (avoiding duplication).
- [x] Each group member works on their endpoint method initially.
- [x] Each group member pushes their code to GitHub repository (on own branch), and requests  PR request from the other members.
- [x] The member than notifies the team on Slack that there are PRs waiting.
- [x] Another group member reviews the branch, discusses/resolves any conflicts and merges to main when satisfied. 
- [x] Upon writing new code, each member regularly pulls from remote main branch to ensure they are working on the most updated version. 

## Methods/Functionality (REST ENDPOINTS) - discussed during meeting:
### GET:`findByBlendTypeAndStrength()`: Search and return products matching blend type AND strength (both values much match).
### POST:`addNewProduct()`: Add a new coffee product.
### PUT:`updateStock()`: Update coffee stock to a specific amount.
### PUT:`adjustStock()`: Adjusts coffee stock by an amount, can be negative or positive.
### PATCH:`updatePrice():` Update only the price of a coffee product.
### DELETE:`deleteProduct()`: Delete a coffee product by ID

## **3. TESTING**
Once all endpoint method logic had been instantiated, we will move on the testing phase*. This will involve:
1. Manual Testing (using Postman)
2. Automated Unit Testing (in IntelliJ IDEA, using JUnit and Mockito dependencies) 

<N.B.Full details regarding the test plan can be found in: `documentation/testing-plan.md`.>
## **4. CONTAINERISATION USING DOCKER**
{NEEDS UPDATING!}
## GROUP/INDIVIDAL ROLES & RESPONSIBILITIES
### Methods of Communication:
- Zoom meetings throughout the course of the four weeks to discuss:
  - initial project ideas
  - group member availabilities (for logistics of meetings)
  - group member strengths/interests (where relevant for project)
- Slack channel:
  - where adhoc/further discussion/explanation of code/idea was needed
  - to flag when a PR needed review
  - to organise zoom meetings/send link to meetings
  - to add files such as presentation documents/snip images etc.
- GitHub:
  - group collaboration
  - raising pull requests
  - reviewer assigning
  - 


