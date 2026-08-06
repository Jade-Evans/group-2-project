# Project Documentation

## Project Description:
A Spring Boot REST API created with the intention of being used by small independent businesses to 
keep track of product stock counts and retrieve stock information.
or the purpose
of demonstration - because all developers need coffee! - we have based ours on a small fictitious coffee product company, "Beans & Grounds Coffee Store".
As the name suggests!), the company sells bags of their
own coffee blends in both bean and ground varieties. 
The Database used to store information includes data on the following:
- Name (of product)
- Type of Blend
- Weight(grams)
- Strength
- Total number of orders of a particular product
- Total in stock

The App will use various REST endpoint methods to store, update and retrieve data regarding the products themselves and stock numbers. .
The App will be connected to a MySql Database via the use of JPA Entities.
This API could potentially be adapted for use for various small companies. It's main purposes are:
- storage, retrieval, amendment and updating of data in relation to all products sold int he store.
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
Using POSTMAN, we will manually each other's endpoints to make sure they work as we would expect:

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

### Test Endpoint: findByBlendTypeAndStrength()
- *URL Tested:* `http://localhost:8080/products/GROUND/3`
- *Purpose:* Search and return coffee products matching both blend and strength.
- *Expected Result:* Products with blend type `GROUND` and `Strength` 3 should be returned.
- *Actual Result:* Four matching products were successfully returned, including Colombian Gold and House Blend products with strength 3 and blend type GROUND.

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

### Test Endpoint: deleteProduct          
-*URL Tested:* `http://localhost:8080/products/27`
- *Purpose:* Deletes a coffee product from the catalogue using its ID.
- *Expected Result:* The product with 27 should be removed and the API should return HTTP 204 No Content.
- *Actual Result:* Product with ID 27 was successfully deleted and HTTP 204 No Content was returned.

# Rough Notes for Automated Testing:
Once the manual tests above had been completed and we were satisfied that the methods all worked with the "happy paths", 
we move on to creating unit testing using JUNIt and Mockito. 
We first created mock database using Mockito, which is accessible globally from whichever test.
We created tests in correspondence to the endpoint methods we had each created. 
We took into account: valid, invalid and boundary/edge case inputs relevant to the particular method. 
Wr ran the automated tests to see if they passed or failed. 
WE debug/ made amendments where the tests fail, and retest until all tests pass.
![img.png](img.png)
✔ valid inputs
✔ input normalisation (case/whitespace)
✔ invalid strings
✔ invalid strength values
✔ boundary value (5)
✔ no-results scenario