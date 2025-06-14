# Stage 1: Construction
FROM maven:3.9.6-eclipse-temurin-17 AS builder

# Working directory
WORKDIR /app

# Copy pom.xml & download dependencies firts
COPY pom.xml .
COPY .mvn .mvn
COPY mvnw .
RUN ./mvnw dependency:go-offline

# Copy the source
COPY src ./src

# Compile project
RUN ./mvnw clean package -DskipTests

# Stage 2: Image
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copiar el jar compilado desde el contenedor builder
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
