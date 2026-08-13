# 📝Project Requirements

---

## 1️⃣ Design Your Application Requirements *(Week 1)*

### Create a `documentation` with markdown files detailing the following:
   - [x] Application summary and requirements
   - [x] Implementation plan to achieve the above
   - [x] Test plan to achieve the above

---

## 2️⃣ Create a Spring Boot App *(Week 2)*

### [x] The above, using the Spring Initializr

---

## 3️⃣ REST Endpoints

- [x] Utilise endpoints with appropriate parameters
- [x] Consider response codes and return values
- [x] Create an OpenAPI spec, and add the URL to this in the `README.md`
---

## 4️⃣ Connecting Database

- [x] Create a relevant MySQL database and table for the app
- [x] Establish a connection between the app and the IDE (MySQL Workbench/DBeaver)
- [x] Add the above code in a `.sql` file within the project
- [x] Create an Entity for your table using JPA
- [x] Create a Repository for your table using JPA
- [x] Use the repository for database interactions to:
   - [x] Retrieve data from the table
   - [x] Save data to the table

---

## 5️⃣ Testing

- [x] Unit test the majority of methods
- [x] Mock any external dependencies using Mockito

---

## 6️⃣ Exceptions

- [x] Handle exceptions appropriately

---

## 7️⃣ Docker *(Week 4)*

- [x] Create a Dockerfile to create an image of your application
- [x] Use your image in a `docker-compose.yaml` file, alongside one other service
- [x] Provide sufficient instructions on how to use Docker files

---

## 8️⃣ Further Documentation

- [] Create a document to propose your deployment plans
- [] This should include a pipeline (can be a diagram, or a list)
- [] Detail the stages you will have, including any testing

---

## 9️⃣ General (Spring) Coding 

- [x] Utilise an appropriate class architecture
- [x] Use constructors appropriately, and cleanly (e.g. using Lombok annotations)
- [x] Use logs appropriately, using `@Slf4j` or otherwise
- [x] Appropriate use of Spring Boot configuration
- [x] Store necessary values here, and retrieve appropriately in code
- [x] Add to your `README.md` with running instructions
- [x] Include information about how to edit configuration as required

---

## Things to do this week:
### Code:
Have we:
- included unit tests for their methods, using Mockito mock dependencies if needed?
- checked all automated checks pass?
- pushed to GitHub/PR?
- updated services/code to handle exceptions where needed.
- demonstrated thorough use of logging throughout code?

## Documentation
### Docker Document:
- Create a document to propose your deployment plans
- Provide sufficient instructions on how to use Docker files
- Include a pipeline (diagram or list)
- Detail the stages you will have, including any testing
(example pipeline stages below:
Code pushed / PR merged to main
Build (compile the app, e.g. via Maven/Gradle)
Testing (run unit tests, maybe integration tests) ← this is the "including any testing" part
Package (e.g. build the Docker image)
Push image to a registry (e.g. Docker Hub)
Deploy (e.g. to a server, cloud service, or container orchestrator))

### README.md:
General content check
General neaten up structure
Remove any reference to CFG
Add reference to docker
Check running instructions ESPECIALLY information about how to edit configuration as required

## Implementation and Testing PLans:
Update folder structure with docker file