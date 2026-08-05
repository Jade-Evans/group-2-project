# =========================================================================
# STAGE 1: Build the application
# =========================================================================
# base images: https://docs.docker.com/build/building/base-images/
#You can omit stage 1 if willing to build the jar manually
FROM eclipse-temurin:25-jdk-noble AS build

WORKDIR /app

RUN apt-get update && \
    apt-get install -y --no-install-recommends maven && \
    rm -rf /var/lib/apt/lists/*


COPY pom.xml .
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests -B

# =========================================================================
# STAGE 2: Run the application
# =========================================================================

FROM eclipse-temurin:25-jre-noble

WORKDIR /app

COPY --from=build /app/target/*-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]