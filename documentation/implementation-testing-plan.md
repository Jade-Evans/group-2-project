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
Using POSTMAN, we will manually each other's endpoints to make sure they work as we would expect:

### Test Endpoint: adjustStock()
- *URL Tested:* `http://localhost:8080/products/adjustStock/1?amount=5`
- *Purpose:* Increase stock level of product with ID 1 by a specified amount.
- *Expected Result:* Stock increases from 50 → 55.
- *Actual Result:* Stock correctly adjusted to 55.

<img width="1442" height="947" alt="image" src="https://github.com/user-attachments/assets/c05814af-2252-4e29-b996-780fe114a921" />


### Test Endpoint: updateStock()
- *URL Tested:* `http://localhost:8080/products/updateStock/1?quantity=50`
- *Purpose:* Set the stock level of product with ID 1 to a specific quantity.
- *Expected Result:* Stock resets to 50.
- *Actual Result:* Stock correctly updated to 50.

<img width="1440" height="940" alt="image" src="https://github.com/user-attachments/assets/0997007c-8258-4da9-959c-89312aaaca57" />


### Test Endpoint: findByBlendTypeAndStrength()
- *URL Tested:* `http://localhost:8080/products/GROUND/3`
- *Purpose:* Search and return coffee products matching both blend and strength.
- *Expected Result:* Products with blend type `GROUND` and `Strength` 3 should be returned.
- *Actual Result:* Four matching products were successfully returned, including Colombian Gold and House Blend products with strength 3 and blend type GROUND.

<img width="1447" height="947" alt="image" src="https://github.com/user-attachments/assets/851974ed-8980-40a0-acf0-410cf052af07" />


- 

### Test Endpoint: addNewProduct()
- *URL Tested:* * `http://localhost:8080/products`
- *Method* POST
- *Purpose:* To add a new coffee product to the catalogue and store it in the database.
- *Expected Result:* A new coffee product should be created successfully, saved in the database and returned with a generated product ID.
- *Actual Result:* A new product was successfully added.The API returned HTTP 201 created with the created product details,including the generated ID (61). The product was successfully stored in the MYSQL database.
- *Response*
```json
{
    "id": 61,
    "name": "Test Blend",
    "weightInGrams": 250,
    "strength": 3,
    "decaf": false,
    "price": 8.99,
    "orderTotal": 0,
    "stockTotal": 25,
    "coffeeType": "BEAN"
}
```

<img width="1438" height="951" alt="image" src="https://github.com/user-attachments/assets/7aacea70-f4ca-4e1d-a894-104ffa034efc" />


### Test Endpoint: updatePrice()

- *URL Tested:* `http://localhost:8080/products/11/price?price=14.50`
- *(Replace **11** with a valid product ID.)*
- *Purpose:* Update only the price of an existing coffee product without modifying any other product details.
- *Expected Result:* The product price is updated while all other product information remains unchanged.
- *Actual Result:* The product price was successfully updated and all remaining fields were unchanged.

<img width="1435" height="938" alt="image" src="https://github.com/user-attachments/assets/98e4eb78-1382-4629-ae42-110f6f7150da" />


### Test Endpoint: deleteProduct          
-*URL Tested:* `http://localhost:8080/products/27`
- *Purpose:* Deletes a coffee product from the catalogue using its ID.
- *Expected Result:* The product with 27 should be removed and the API should return HTTP 204 No Content.
- *Actual Result:* Product with ID 27 was successfully deleted and HTTP 204 No Content was returned.

<img width="1437" height="942" alt="image" src="https://github.com/user-attachments/assets/290cf2be-72bf-4b34-8df4-8850b2c5d350" />
