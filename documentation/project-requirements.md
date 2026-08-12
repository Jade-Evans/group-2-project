Project Requirements:
How we met the requirements checklist:
# ✅ Project Requirements Checklist

---

## 1️⃣ Design Your Application Requirements *(Week 1)*

- [x] Within markdown files, in a `documentation` directory in your project, create documentation that covers:
   - [x] Your application requirements and a summary of the app itself
   - [x] How you will achieve these
   - [x] A manual test plan

---

## 2️⃣ Create a Spring Boot App *(Week 2)*

- [x] Using the Spring Initializr, or otherwise

---

## 3️⃣ REST Endpoints *(Week 2)*

- [x] Utilise endpoints with appropriate parameters
   - [x] Consider response codes and return values
- [x] Create an OpenAPI spec, and add the URL to this in the `README.md`
---

## 4️⃣ Connecting Database *(Week 2)*

- [x] Create a database in MySQL Workbench/DBeaver
   - [x] Add this code in a `.sql` file within the project for reference
- [x] Create and initialise your table in MySQL Workbench/DBeaver
   - [x] Add this code in a `.sql` file within the project for reference
- [x] Using JPA:
   - [x] Create an Entity for your table
   - [x] Create a Repository for your table
- [x] Utilise your repository for database interactions in your program to:
   - [x] Retrieve data from the table
   - [x] Save data to the table

---

## 5️⃣ Testing *(Week 3)*

- [] Unit test the majority of methods
- [] Mock any external dependencies using Mockito

---

## 6️⃣ Exceptions *(Week 3)*

- [] Handle exceptions appropriately

---

## 7️⃣ Docker *(Week 4)*

- [x] Create a Dockerfile to create an image of your application
- [x] Use your image in a `docker-compose.yaml` file, alongside one other service
- [] Provide sufficient instructions on how to use Docker files

---

## 8️⃣ Further Documentation *(Weeks 2–4)*

- [] Create a document to propose your deployment plans
   - [] This should include a pipeline (can be a diagram, or a list)
   - [] Detail the stages you will have, including any testing

---

## 9️⃣ General (Spring) Coding *(Week 1 onwards)*

- [x] Utilise an appropriate class architecture
- [x] Use constructors appropriately, and cleanly (e.g. using Lombok annotations)
- [] Use logs appropriately, using `@Slf4j` or otherwise
   - [x] If you choose to use another method of logging, this will be taken into consideration provided you detail the choice in your documentation
- [x] Appropriate use of Spring Boot configuration
   - [x] Store necessary values here, and retrieve appropriately in code
- [] Add to your `README.md` with running instructions
   - [] Include information about how to edit configuration as required

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