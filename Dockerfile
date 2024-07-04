# Use a base image with Java and Maven installed
FROM maven:3.9.7-sapmachine-22 AS build

# Set the working directory in the container
WORKDIR /app

# Copy the parent pom.xml file
COPY pom.xml .

# Copy the pom.xml files for each module
COPY domain/pom.xml domain/
COPY infrastructure/pom.xml infrastructure/
COPY application/pom.xml application/

# Download all required dependencies into one layer
RUN mvn dependency:go-offline -B

# Copy source files
COPY domain/src/ domain/src/
COPY infrastructure/src/ infrastructure/src/
COPY application/src/ application/src/

# Build the application
RUN mvn package -DskipTests

# Use a smaller base image for the runtime
FROM openjdk:22-slim

WORKDIR /app

# Copy the built artifact from the build stage and rename it to app.jar
COPY --from=build /app/application/target/application-*.jar ./app.jar

# Set the startup command to run your application
ENTRYPOINT ["java", "-jar", "/app/app.jar"]