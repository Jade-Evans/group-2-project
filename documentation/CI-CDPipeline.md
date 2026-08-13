# Docker Document and CI/CD Pipeline

## CI/CD Pipeline
Our overall production plan will follow the CI/CD Principles:
```mermaid
flowchart LR
  A[Stage 1: Manual Development (GitHub)] --> B[Stage 2: Build/Compile (Maven)]
  B --> C[Stage 3: Automated Testing (JUnit/Mockito]
  C --> D[ Stage 4: Packaging (Docker Image)]
  D --> E[Stage 5: Pushing (Docker Registry)]
  E --> F[Stage 6: Deploying]
```
## Development 
### Stage 1: GitHub activity
This relates to the non-automated, human aspect of the development.
It triggers the CI/CD pipeline.
Our plan: We will use git commands and GitHub to actively add, commit, raise PRs, review, merge and pull code updates into main.
### Stage 2: Compile
This relates to the first automated Continuous Integration stage.
This is when the code merged into main is automatically compiled (build stage).
Our plan: We used Maven as our build tool, which will handle dependencies and ensure no errors prior to automated testing.
### Development Stage 3: Testing
This relates to automated testing in the Continuous Integration stage.
Our plan: We will write appropriate unit tests for most methods to ensure the robustness of our code and exception handling.
Any errors will be debugged prior to moving on to the deployment phase. See the TestingPlan.md for full details.
## Deployment 
### Stage 4: Packaging
This relates to the stage once automated testing has been carried out successfully and the app is ready to be packaged into a deployable object.
Our plan: We will use Docker and create a Dockerfile to produce an Image of the application.
### Stage 5: Pushing
This relates to the Docker image being pushed to the cloud registry i.e. Docker Hub.
### Stage 6: Deployment
This relates to the containerised app being pulled from the cloud registry and run on any environment.
Our plan: We will create a docker-compose.yml to facilitate the running of the app. This will include a version of the DB so the user doesn't need to create their own.
