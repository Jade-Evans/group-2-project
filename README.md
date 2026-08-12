# "Beans&Grounds Coffee Store" API

## Project Overview:

An API to be used to store, update and retrieve data regarding the products sold in a small
independent store that sells coffee products. 

## Initial Backend Design:
The diagram below illustrates the initial backend design of the Coffee application, including the corresponding REST endpoints, service methods, repository interactions, and database.


```mermaid
flowchart TD
    Client["Client"]

    Client -->|"GET /products/{blendType}/{strength}"| SearchByType["findByBlendTypeAndStrength(blendType, strength)"]
    Client -->|"POST /products"| CreateProduct["addProduct(product)"]
    Client -->|"PUT /products/stock/{id}"| UpdateStock["updateStock(id, quantity)"]
    Client -->|"PUT /products/adjustStock/{id}"| AdjustStock["adjustStock(id, amount)"]
    Client -->|"PATCH /products/{id}/price"| UpdatePrice["updatePrice(id, price)"]
    Client -->|"DELETE /products/{id}"| DeleteById["deleteProduct(id)"]

    SearchByType -->|"findByBlendTypeAndStrength(blendType, strength)"| Repository
    CreateProduct -->|"save(product)"| Repository
    UpdateStock -->|"findById(id) + save(product)"| Repository
    AdjustStock -->|"findById(id) + save(product)"| Repository
    UpdatePrice -->|"findById(id) + save(product)"| Repository
    DeleteById -->|"delete(product)"| Repository

    Repository --> Database[("MySQL<br/>coffeeDB.products")]
```
## Setup/How to Run:
### 1. Clone this repository to your local machine:
    ```bash
    git clone <repository-url>
    cd group-2-project
    ```
### 2. Configure the database credentials:
   The application uses environment variables for the database username and password.

    In IntelliJ:

   - Go to **Run → Edit Configurations**.
   - Select the Spring Boot run configuration.
   - Add the following environment variables:

    ```text
    your_sql_username=<your MySQL username>
    your_sql_password=<your MySQL password>
    ```

### 3. Create the 'coffeeDB' database and 'products' table.
   Run the SQL script located in:

    ```text
    src/main/resources/coffeeDB.sql
    ```

    This creates the `coffeeDB` database and initialises the `products` table.

### 4. Running the application with Docker 
    > **TODO (Ameenah):** Confirm these instructions once the Docker configuration has been finalised.

    - Ensure Docker Desktop is running.
      - From the project root, run:
    
    ```bash
    docker compose up -d
    ```
    
    - To stop the containers:
    
    ```bash
    docker compose down
    ```

### 5. View the API documentation
Once the application is running, Swagger UI is available at:

    ```
    http://localhost:8080/swagger-ui/index.html
    ```

### Running via Docker
1. Build and start both the application container and MySQL container:
   ```bash
   docker compose up --build
   ```
2. The application will start on `http://localhost:8080` 
3. To stop the containers, run:
   ```bash
   docker compose down
   ```

## Development Tools/Tech Stack:
### Languages:
- Java (Java Version: JDK 25)
- MySQL

### Frameworks:
- Maven
- Spring Boot

### IDE:
- IntelliJ IDEA

### Dependencies:
- **Spring Boot Starter** — to configure Spring Boot automatically & manage dependencies
- **Spring Boot Starter Web** — for building REST APIs and web apps
- **Spring Boot Starter Data JPA** — ORM and database access via Hibernate and Spring Data repositories
- **Spring Boot Starter Test** — support testing via JUnit, Mockito, AssertJ, Spring Test etc.
- **Lombok** — uses annotations to reduce boilerplate code for cleaner code (getters, setters, constructors)
- **MySQL Connector/J** — for MySQL database connection
- **SpringDoc OpenAPI Starter WebMVC UI** — generates interactive OpenAPI documentation
- **JUnit** — unit testing framework
- **JUnit Jupiter** — JUnit 5 testing API
- **Mockito Core** — mocking framework used for unit tests

### Software
- Postman (REST endpoint testing)
- DBeaver (Database Creation)

