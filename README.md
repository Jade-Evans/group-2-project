# "Beans&Grounds Coffee Store" API

## Project Overview:

An API to be used to store, update and retrieve data regarding the products sold in a small
independent store that sells coffee products. 

## Initial/MVP Functionality:

- GET: retrieve a list of products WHERE coffeeType = BEAN;
- POST: add a new coffee product to the DB;


```mermaid

flowchart TD
    Client["Client"]
    Client -->|"GET /products/search?CoffeeType=BEAN"| GetByType["searchByType(CoffeeType)"]
    Client -->|"POST /products/addProduct"| Create["addProduct(product)"]

    GetByType -->|"findByType(CoffeeType)"|Repository
    Create -->|"save(product)"| Repository
  
    Repository --> Database[("MySQL<br/>coffeeDB.products")]

```
## Setup/How to Run:
1. Clone this repository to your local repository.
2. Configure: copy the application-template.yaml boilerplate into your own application.yaml file.
3. Update the username and password with your own MySql credentials.
4. Create the coffeeDB database and products table (code in resources/coffeeDB.sql file).
5. Open the cloned project
6. Go to Group2projectApplication.java.
7. Run project. 

## API Specification:
Once this repository has been cloned and the application run, you can view the API documentation
at: http://localhost:8080/swagger-ui/index.html#/

## Development Tools/Tech Stack:
### Language(s):
- Java (Java Version: JDK 25 (LTS))
- MySQL

### Frameworks:
- Maven
- Spring Boot

### IDE:
- IntelliJ IDEA

### Dependencies/Plugins:
- Lombok
- Spring Web
- Spring Data JPA
- Spring Doc OpenAPI
- MySQL Driver

### Software
- Postman (REST endpoint testing)
- DBeaver (Database Creation)

