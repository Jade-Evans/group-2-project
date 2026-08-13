# Project Implementation

## ☕ Project Brief/Description

As part of the CFG +Masters in Java, Group 2 have created a small Spring Boot API that addresses the following scenario:

- An independent coffee company sells bags of their own ground/bean coffee in a variety of blends, sizes etc.
- They need an app that can connect to their product database and provide the following initial functionality:
  - Add new products to the database
  - Delete obsolete products from the database
  - Update pricing of a certain product
  - Update stock count of a certain product
  - Adjust stock count of a certain product
  - Retrieve information on products matching certain criteria i.e. retrieving only Ground coffee with a strength of 3.
- The App will use various REST endpoint methods to store, update and retrieve data regarding the products themselves and stock numbers.
- The App will connect to a MySQL Database via the use of JPA Entities.
- This API could potentially be adapted for use for various small companies. Its main purposes are: storage, retrieval, amendment and updating of data in relation to all products sold in the store.

---

## Implementation Plan

### 🏗️ Phase 1: Setup

- [x] Use Spring Initializr to create a Spring Boot API with `application.yaml` and known dependencies.
  - [x] Create GitHub repository and add all group members as collaborators.
    - [x] Populate the API with template/base requirement files, including:
      - [x] `documentation` folder for MD file detailing implementation, testing and project requirements.
      - [x] Create overall folder structure:


        group2project/
        ├── .idea/
        ├── .mvn/
        ├── db/
        ├── documentation/
        ├── src/
        │   ├── main/
        │   │   ├── java/
        │   │   │   └── com/cfgmasters/CoffeeApp/
        │   │   │       ├── controllers/
        │   │   │       │   └── CoffeeProductController.java
        │   │   │       ├── model/
        │   │   │       │   ├── entities/
        │   │   │       │   │   └── CoffeeProduct.java
        │   │   │       │   └── enums/
        │   │   │       │       └── CoffeeType.java
        │   │   │       ├── repositories/
        │   │   │       │   └── CoffeeProductRepository.java
        │   │   │       ├── services/
        │   │   │       │   └── CoffeeProductService.java
        │   │   │       ├── utils/
        │   │   │       │   └── ValidInputChecksUtils.java
        │   │   │       └── CoffeeApp.java
        │   │   └── resources/
        │   │       ├── application.yaml
        │   │       └── coffeeDB.sql
        │   └── test/
        │       └── java/
        │           └── com/cfgmasters/group2project/services/
        │               └── CoffeeProductServiceTests.java
        ├── .env.example
        ├── .gitignore
        ├── docker-compose.yml
        ├── Dockerfile
        ├── mvnw
        ├── mvnw.cmd
        ├── pom.xml
        └── README.md
         

### 🗄️ Phase 2: Database Connection & Config

- [x] **Database setup:** Use MySQL IDE to create:
  - [x] Coffee database
  - [x] Products table
  - [x] Insert seed data for testing
- [x] Configuration:
  - [x] Configure database credentials using environment variables.
  - [x] Store local credentials outside the repository.
- [x] Database credentials are provided through environment variables to avoid committing sensitive information to the repository.
- [x] Test connection and configuration settings are working and app runs as expected (see manual testing).

### 🔌 Phase 2: REST Endpoints

Once set up, configuration and database connection are confirmed, the following will be implemented:

- [x] Group discussion in which each member proposes one **REST endpoint** method (avoiding duplication).
- [x] Each group member works on their endpoint method initially.
- [x] Each group member pushes their code to GitHub repository (on own branch), and requests a PR from the other members.
- [x] The member then notifies the team on Slack that there are PRs waiting.
- [x] Another group member reviews the branch, discusses/resolves any conflicts and merges to main when satisfied.
- [x] Upon writing new code, each member regularly pulls from remote main branch to ensure they are working on the most updated version.

#### Methods/Functionality (REST Endpoints) — discussed during meeting:

| Method | Endpoint | Description |
|--------|----------|-------------|
| `GET` | `findByBlendTypeAndStrength()` | Search and return products matching blend type **and** strength (both values must match). |
| `POST` | `addNewProduct()` | Add a new coffee product. |
| `PUT` | `updateStock()` | Update coffee stock to a specific amount. |
| `PUT` | `adjustStock()` | Adjusts coffee stock by an amount, can be negative or positive. |
| `PATCH` | `updatePrice()` | Update only the price of a coffee product. |
| `DELETE` | `deleteProduct()` | Delete a coffee product by ID. |

### ✅ Phase 3: Testing

Once all endpoint method logic had been instantiated, we will move on to the testing phase. This will involve:

1. Manual Testing (using Postman)
2. Automated Unit Testing (in IntelliJ IDEA, using JUnit and Mockito dependencies)

> 📄 **N.B.** Full details regarding the test plan can be found in: `documentation/testing-plan.md`

### 🐳 Phase 4: Containerisation Using Docker

Docker support has been implemented to provide a consistent development environment across the team.

> **TODO:** Ameenah to update this section with the final Docker architecture and usage instructions once the Docker configuration has been finalised.
---

## 🤝 Group Work

### Methods of Communication

- **Zoom** meetings throughout the course of the four weeks to discuss:
  - initial project ideas
  - group member availabilities (for logistics of meetings)
  - group member strengths/interests (where relevant for project)
- **Slack** channel:
  - where adhoc/further discussion/explanation of code/idea was needed
  - to flag when a PR needed review
  - to organise Zoom meetings/send link to meetings
  - to add files such as presentation documents/snip images etc.
- **GitHub:**
  - group collaboration
  - raising pull requests
  - assigning team members as reviewers for PRs

### 👥 Roles & Responsibilities

All team members were responsible for and took part in the following:

- contributing to project ideas and group discussions, and regular communication
- creating at least one endpoint with relevant exception handling
- pushing new work to GitHub and requesting reviews
- reviewing others' code contributions on GitHub
- creating thorough automated unit testing for their particular endpoint

In addition, we also had the following responsibilities:

- **Jade:** App/project set up and documentation writing
- **Andrina:** Presentation — creation of slideshow and presenting
- **Ameenah:** Docker
- **Caroline:** Manual testing using Postman (and recording results in testing plan)
- **Kerene:** Manual testing using Postman (and recording results in testing plan)