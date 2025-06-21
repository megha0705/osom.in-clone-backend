# Use official Maven image with Java
FROM maven:3.9.5-eclipse-temurin-21 as build

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Package the application
RUN mvn clean package -DskipTests

# Use a smaller Java runtime for running the app
FROM eclipse-temurin:21-jre

# Set working directory
WORKDIR /app

# Copy the built jar from the previous stage
COPY --from=build /app/target/*.jar app.jar

# Expose port (optional)
EXPOSE 8080

# Run the app
CMD ["java", "-jar", "app.jar"]
